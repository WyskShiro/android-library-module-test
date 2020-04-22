package com.jera.apptemplate.domain.interactors.user

import com.jera.apptemplate.domain.boundary.UserRepository
import com.jera.apptemplate.domain.entity.User
import com.jera.apptemplate.domain.form.user.LoginForm
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