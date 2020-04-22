package com.jera.apptemplate.data.repository

import com.jera.apptemplate.data.client.ApiClient
import com.jera.apptemplate.data.entity.user.ApiUserLogInRequest
import com.jera.apptemplate.data.entity.user.ApiUserSignUpRequest
import com.jera.apptemplate.domain.boundary.UserRepository
import com.jera.apptemplate.domain.entity.User
import com.jera.apptemplate.domain.entity.error.RequestException
import com.jera.apptemplate.domain.form.user.LoginForm
import com.jera.apptemplate.domain.form.user.RecoverPasswordForm
import com.jera.apptemplate.domain.form.user.SignUpForm
import com.jera.apptemplate.domain.util.resource.CURRENT_USER
import com.jera.apptemplate.domain.util.storage.Cache

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