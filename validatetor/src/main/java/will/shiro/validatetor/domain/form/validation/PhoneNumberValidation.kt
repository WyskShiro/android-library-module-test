package will.shiro.validatetor.domain.form.validation

class PhoneNumberValidation(
    override val isRequired: Boolean = true
) : will.shiro.validatetor.domain.form.validation.BaseValidation {

    override var text: String? = null

    override fun isValid(): Boolean {
        return text?.run { matches(will.shiro.validatetor.domain.form.validation.PhoneNumberValidation.Companion.PHONE_NUMBER_PATTERN.toRegex()) } ?: false
    }

    companion object {
        const val PHONE_NUMBER_PATTERN = "(\\(\\d{2}\\) \\d{5}-\\d{4})"
    }
}