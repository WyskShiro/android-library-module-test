package will.shiro.validatetor.domain.interactors.user

import will.shiro.validatetor.domain.boundary.UserRepository
import will.shiro.validatetor.domain.entity.User
import will.shiro.validatetor.domain.form.user.LoginForm
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LogIn constructor(private val repository: UserRepository) {

    suspend fun execute(loginForm: LoginForm): User? {
        return withContext(Dispatchers.IO) {
            if (!loginForm.isValid()) throw loginForm.exception
            else repository.signIn(loginForm)
        }
    }
}