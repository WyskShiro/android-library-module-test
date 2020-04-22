package com.jera.apptemplate.domain.entity.error

import java.io.IOException
import java.net.SocketTimeoutException

class RequestException private constructor(
    val errorCode: Int?,
    val errorMessage: String?,
    private val errorType: ErrorType,
    val throwable: Throwable?
) : Exception() {

    companion object {
        fun httpError(errorCode: Int, message: String? = null): RequestException {
            return RequestException(errorCode, message, ErrorType.HTTP, null)
        }

        fun networkError(exception: IOException): RequestException {
            return RequestException(null, null, ErrorType.NETWORK, exception)
        }

        fun timeoutError(exception: SocketTimeoutException): RequestException {
            return RequestException(null, null, ErrorType.TIMEOUT, exception)
        }

        fun unexpectedError(throwable: Throwable): RequestException {
            throwable.printStackTrace()
            return RequestException(null, throwable.message, ErrorType.UNEXPECTED, throwable)
        }
    }

    fun isHttpError(): Boolean {
        return errorType == ErrorType.HTTP
    }

    fun isNetworkError(): Boolean {
        return errorType == ErrorType.NETWORK
    }

    fun isUnexpectedError(): Boolean {
        return errorType == ErrorType.UNEXPECTED
    }

    fun isUnauthorizedError(): Boolean {
        return isHttpError() && HttpError.Companion.getErrorForCode(errorCode) == HttpError.UNAUTHORIZED
    }

    fun isTimeOutException(): Boolean {
        return errorType == ErrorType.TIMEOUT || HttpError.Companion.getErrorForCode(errorCode) == HttpError.TIMEOUT
    }

    fun isNotFoundException(): Boolean {
        return isHttpError() && HttpError.Companion.getErrorForCode(errorCode) == HttpError.NOT_FOUND
    }

    fun isUnProcessableEntity(): Boolean {
        return isHttpError() && HttpError.Companion.getErrorForCode(errorCode) == HttpError.UN_PROCESSABLE_ENTITY
    }

    fun isConflictException(): Boolean {
        return isHttpError() && HttpError.Companion.getErrorForCode(errorCode) == HttpError.CONFLICT
    }
}