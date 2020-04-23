package will.shiro.validatetor.domain.form.user

import will.shiro.validatetor.domain.form.validation.EmailValidation
import will.shiro.validatetor.domain.form.validation.PasswordValidation

class LoginForm : will.shiro.validatetor.domain.form.BaseForm() {

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
