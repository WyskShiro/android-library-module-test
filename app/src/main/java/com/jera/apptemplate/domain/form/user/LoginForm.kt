package com.jera.apptemplate.domain.form.user

import com.jera.apptemplate.domain.form.validation.EmailValidation
import com.jera.apptemplate.domain.form.validation.PasswordValidation

class LoginForm : com.jera.apptemplate.domain.form.BaseForm() {

    val emailValidation = EmailValidation()
    val passwordValidation = PasswordValidation()

    override val validationPair = listOf(
        EMAIL_ID to emailValidation,
        PASSWORD_ID to passwordValidation
    )

    companion object {
        const val EMAIL_ID = "EMAIL_ID"
        const val PASSWORD_ID = "PASSWORD_ID"
    }
}
