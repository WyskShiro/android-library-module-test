package will.shiro.validatetor.domain.form.validation

class CpfValidation(
    override val isRequired: Boolean = true
) : will.shiro.validatetor.domain.form.validation.BaseValidation {

    override var text: String? = null

    override fun isValid(): Boolean {
        return text?.run { matches(will.shiro.validatetor.domain.form.validation.CpfValidation.Companion.CPF_PATTERN.toRegex()) } ?: false
    }

    companion object {
        const val CPF_PATTERN = "(\\d{3}.\\d{3}.\\d{3}-\\d{2})"
    }
}