package will.shiro.validatetor.domain.form.validation

class PasswordConfirmationValidation(
    private val passwordValidation: will.shiro.validatetor.domain.form.validation.PasswordValidation,
    override val isRequired: Boolean = true
) : will.shiro.validatetor.domain.form.validation.BaseValidation {

    override var text: String? = null

    override fun isValid(): Boolean {
        return passwordValidation.isValid() && text == passwordValidation.text
    }
}