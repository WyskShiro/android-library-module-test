package will.shiro.validatetor.data.util.request

import will.shiro.validatetor.data.util.formatter.ApiErrorsFormatter
import will.shiro.validatetor.domain.entity.error.RequestException
import kotlinx.coroutines.coroutineScope
import okhttp3.ResponseBody
import retrofit2.Response
import java.io.IOException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

open class RequestHandler {
    protected suspend fun <T : Any> makeRequest(block: Response<T>): T? {
        return coroutineScope {
            try {
                block.run {
                    if (isSuccessful) {
                        body()
                    } else {
                        throw RequestException.httpError(
                            code(),
                            extractErrorBody(errorBody())
                        )
                    }
                }
            } catch (t: Exception) {
                throw when (t) {
                    is RequestException -> t
                    is SocketTimeoutException -> RequestException.timeoutError(t)
                    is UnknownHostException -> RequestException.unexpectedError(t)
                    is IOException -> RequestException.networkError(t)
                    else -> RequestException.unexpectedError(t)
                }
            }
        }
    }

    private fun extractErrorBody(errorBody: ResponseBody? = null): String? {
        return ApiErrorsFormatter.deserialize(errorBody)?.let {
            if (it.errors != null) {
                it.errors.joinToString("\n")
            } else {
                it.errorMessage
            }
        }
    }
}