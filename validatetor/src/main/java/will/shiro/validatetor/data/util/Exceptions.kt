package will.shiro.validatetor.data.util

sealed class Exceptions(message: String): Throwable() {
    object NoObjectReturnedException: Exceptions("")
}