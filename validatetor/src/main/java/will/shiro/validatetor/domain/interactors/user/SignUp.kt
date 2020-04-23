package will.shiro.validatetor.domain.interactors.user

import will.shiro.validatetor.domain.boundary.UserRepository
import will.shiro.validatetor.domain.entity.User
import will.shiro.validatetor.domain.form.user.SignUpForm
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SignUp constructor(private val repository: UserRepository) {

    suspend fun execute(signUpForm: SignUpForm): User? {
        return withContext(Dispatchers.IO) {
            if (!signUpForm.isValid()) throw signUpForm.exception
            else repository.signUp(signUpForm)
        }
    }
}