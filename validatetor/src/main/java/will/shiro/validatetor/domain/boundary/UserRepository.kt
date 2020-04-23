package will.shiro.validatetor.domain.boundary

import will.shiro.validatetor.domain.entity.User
import will.shiro.validatetor.domain.entity.error.RequestException
import will.shiro.validatetor.domain.form.user.LoginForm
import will.shiro.validatetor.domain.form.user.RecoverPasswordForm
import will.shiro.validatetor.domain.form.user.SignUpForm

interface UserRepository {
    suspend fun getCurrentFromRemote(): User
    suspend fun signIn(loginForm: LoginForm): User?
    suspend fun signInWithFacebook(): User
    suspend fun signUp(signUpForm: SignUpForm): User?
    @Throws(RequestException::class)
    suspend fun sendPasswordRecovery(recoverPasswordForm: RecoverPasswordForm)
}