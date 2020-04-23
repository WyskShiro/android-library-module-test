package will.shiro.validatetor.data.repository

import will.shiro.validatetor.data.client.ApiClient
import will.shiro.validatetor.data.entity.user.ApiUserLogInRequest
import will.shiro.validatetor.data.entity.user.ApiUserSignUpRequest
import will.shiro.validatetor.domain.boundary.UserRepository
import will.shiro.validatetor.domain.entity.User
import will.shiro.validatetor.domain.entity.error.RequestException
import will.shiro.validatetor.domain.form.user.LoginForm
import will.shiro.validatetor.domain.form.user.RecoverPasswordForm
import will.shiro.validatetor.domain.form.user.SignUpForm
import will.shiro.validatetor.domain.util.resource.CURRENT_USER
import will.shiro.validatetor.domain.util.storage.Cache

class DefaultUserRepository constructor(
    private val apiClient: ApiClient,
    private val cache: Cache
) : UserRepository {
    override suspend fun signUp(signUpForm: SignUpForm): User? {
        return apiClient.signUp(ApiUserSignUpRequest.transform(signUpForm))
            ?.toDomainObject()
            ?.also { cacheUser(it) }
    }

    override suspend fun getCurrentFromRemote(): User {
        TODO("Not implemented")
    }

    override suspend fun signIn(loginForm: LoginForm): User? {
        return apiClient.signIn(ApiUserLogInRequest.transform(loginForm))
            ?.toDomainObject()
            ?.also { cacheUser(it) }
    }

    override suspend fun signInWithFacebook(): User {
        TODO("not implemented")
    }

    @Throws(RequestException::class)
    override suspend fun sendPasswordRecovery(recoverPasswordForm: RecoverPasswordForm) {
        recoverPasswordForm.emailValidation.text?.let { apiClient.recoverPassword(it) }
    }

    private fun cacheUser(user: User) {
        cache.set(CURRENT_USER, user)
    }
}