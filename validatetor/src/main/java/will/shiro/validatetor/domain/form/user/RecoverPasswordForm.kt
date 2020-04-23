package will.shiro.validatetor.domain.form.user

import will.shiro.validatetor.domain.form.validation.EmailValidation

class RecoverPasswordForm : will.shiro.validatetor.domain.form.BaseForm() {

    val emailValidation = EmailValidation()

    override val validationPair = listOf(EMAIL_ID to emailValidation)

    companion object {
        const val EMAIL_ID = "EMAIL_ID"
    }
}
