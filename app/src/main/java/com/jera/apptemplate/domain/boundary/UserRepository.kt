package com.jera.apptemplate.domain.boundary

import com.jera.apptemplate.domain.entity.User
import com.jera.apptemplate.domain.entity.error.RequestException
import com.jera.apptemplate.domain.form.user.LoginForm
import com.jera.apptemplate.domain.form.user.RecoverPasswordForm
import com.jera.apptemplate.domain.form.user.SignUpForm

interface UserRepository {
    suspend fun getCurrentFromRemote(): User
    suspend fun signIn(loginForm: LoginForm): User?
    suspend fun signInWithFacebook(): User
    suspend fun signUp(signUpForm: SignUpForm): User?
    @Throws(RequestException::class)
    suspend fun sendPasswordRecovery(recoverPasswordForm: RecoverPasswordForm)
}