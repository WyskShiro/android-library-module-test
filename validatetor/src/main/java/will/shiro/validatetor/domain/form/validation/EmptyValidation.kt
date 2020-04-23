package will.shiro.validatetor.domain.form.validation

class EmptyValidation(
    override val isRequired: Boolean = true
) : will.shiro.validatetor.domain.form.validation.BaseValidation {

    override var text: String? = null

    override fun isValid(): Boolean {
        return text?.run { isNotBlank() } ?: false
    }
}