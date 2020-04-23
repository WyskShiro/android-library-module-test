package will.shiro.validatetor.domain.interactors.user

import will.shiro.validatetor.domain.boundary.UserRepository
import will.shiro.validatetor.domain.form.user.RecoverPasswordForm
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RecoverPassword constructor(private val repository: UserRepository) {

    suspend fun execute(recoverPasswordForm: RecoverPasswordForm) {
        return withContext(Dispatchers.IO) {
            if (!recoverPasswordForm.isValid()) throw recoverPasswordForm.exception
            else repository.sendPasswordRecovery(recoverPasswordForm)
        }
    }
}