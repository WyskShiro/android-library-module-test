package com.jera.apptemplate.domain.interactors.user

import com.jera.apptemplate.domain.boundary.UserRepository
import com.jera.apptemplate.domain.form.user.RecoverPasswordForm
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