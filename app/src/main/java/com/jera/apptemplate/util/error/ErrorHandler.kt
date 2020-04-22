package com.jera.apptemplate.util.error

import com.jera.apptemplate.domain.entity.error.HttpError
import com.jera.apptemplate.domain.entity.error.RequestException
import com.jera.apptemplate.domain.util.logger.Logger
import com.jera.apptemplate.domain.util.resource.Strings
import com.jera.apptemplate.util.viewmodel.DialogData
import com.jera.apptemplate.util.viewmodel.placeholder.Placeholder
import com.jera.apptemplate.util.viewmodel.placeholder.types.Action
import com.jera.apptemplate.util.viewmodel.placeholder.types.Message

class ErrorHandler constructor(
    private val strings: Strings,
    private val logger: Logger,
    private val loginAction: () -> Unit
) {

    fun getPlaceholder(throwable: Throwable, retryAction: (() -> Unit)?): Placeholder {
        logger.e(throwable)
        return if (throwable is RequestException) {
            handleError(throwable, retryAction)
        } else {
            getUnknownErrorPlaceholder()
        }
    }

    fun getDialogData(
        throwable: Throwable,
        retryAction: (() -> Unit)?,
        onDismiss: (() -> Unit)? = null
    ): DialogData {
        val data = getPlaceholder(throwable, retryAction)
        return when (data) {
            is Action -> {
                DialogData.error(strings, data.message, data.buttonText, data.action)
            }
            else -> {
                DialogData.error(strings, getUnknownErrorMessage(), onDismiss = onDismiss)
            }
        }
    }

    private fun handleError(
        throwable: Throwable,
        tryAgainAction: (() -> Unit)? = null
    ): Placeholder {
        logger.e(throwable)
        return if (throwable is RequestException) {
            handleRequestException(throwable, tryAgainAction)
        } else {
            unexpectedErrorData(tryAgainAction)
        }
    }

    private fun handleRequestException(
        exception: RequestException,
        tryAgainAction: (() -> Unit)? = null
    ): Placeholder {
        return when {
            exception.isUnProcessableEntity() -> unProcessableEntityErrorData(
                exception.errorMessage
                    ?: strings.errorUnknown
            )
            exception.isTimeOutException() -> timeoutErrorData(tryAgainAction)
            exception.isNetworkError() -> httpErrorData(strings.errorNetwork, tryAgainAction)
            exception.isUnauthorizedError() -> unauthorizedErrorData(
                exception.errorMessage
                    ?: strings.errorUnknown
            )
            exception.isHttpError() -> resolveHttpError(exception, tryAgainAction)
            else -> unexpectedErrorData(tryAgainAction)
        }
    }

    private fun resolveHttpError(
        exception: RequestException,
        tryAgainAction: (() -> Unit)?
    ): Placeholder {
        return when (com.jera.apptemplate.domain.entity.error.HttpError.getErrorForCode(exception.errorCode)) {
            com.jera.apptemplate.domain.entity.error.HttpError.NOT_FOUND -> notFoundErrorData(
                exception.errorMessage
                    ?: strings.errorNotFound
            )
            com.jera.apptemplate.domain.entity.error.HttpError.TIMEOUT -> timeoutErrorData(tryAgainAction)
            com.jera.apptemplate.domain.entity.error.HttpError.INTERNAL_SERVER_ERROR -> httpErrorData(strings.errorUnknown, tryAgainAction)
            else -> httpErrorData(
                exception.errorMessage
                    ?: exception.message
                    ?: strings.errorUnknown, null
            )
        }
    }

    private fun notFoundErrorData(errorMessage: String): Placeholder {
        return Message(
            errorMessage
        )
    }

    private fun unauthorizedErrorData(errorMessage: String): Placeholder {
        return Action(
            errorMessage,
            strings.globalDoLogin,
            loginAction
        )
    }

    private fun unProcessableEntityErrorData(errorMessage: String?): Placeholder {
        return Message(
            errorMessage ?: strings.errorUnknown
        )
    }

    private fun httpErrorData(message: String, tryAgainAction: (() -> Unit)? = null): Placeholder {
        return tryAgainPlaceholder(message, tryAgainAction)
    }

    private fun timeoutErrorData(tryAgainAction: (() -> Unit)? = null): Placeholder {
        return tryAgainPlaceholder(strings.errorSocketTimeout, tryAgainAction)
    }

    private fun unexpectedErrorData(tryAgainAction: (() -> Unit)? = null): Placeholder {
        return tryAgainPlaceholder(strings.errorUnknown, tryAgainAction)
    }

    private fun tryAgainPlaceholder(
        errorMessage: String,
        tryAgainAction: (() -> Unit)?
    ): Placeholder {
        return Action(
            errorMessage,
            strings.globalTryAgain,
            tryAgainAction ?: {})
    }

    private fun getUnknownErrorPlaceholder(): Placeholder {
        return Message(
            getUnknownErrorMessage()
        )
    }

    private fun getUnknownErrorMessage(): String {
        return strings.errorUnknown
    }
}
