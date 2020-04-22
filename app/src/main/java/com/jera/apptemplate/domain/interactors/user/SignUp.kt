package com.jera.apptemplate.domain.interactors.user

import com.jera.apptemplate.domain.boundary.UserRepository
import com.jera.apptemplate.domain.entity.User
import com.jera.apptemplate.domain.form.user.SignUpForm
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