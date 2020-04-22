package com.jera.apptemplate.domain.form.user

import com.jera.apptemplate.domain.form.validation.EmailValidation

class RecoverPasswordForm : com.jera.apptemplate.domain.form.BaseForm() {

    val emailValidation = EmailValidation()

    override val validationPair = listOf(EMAIL_ID to emailValidation)

    companion object {
        const val EMAIL_ID = "EMAIL_ID"
    }
}
