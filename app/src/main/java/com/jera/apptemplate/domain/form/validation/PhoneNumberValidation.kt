package com.jera.apptemplate.domain.form.validation

class PhoneNumberValidation(
    override val isRequired: Boolean = true
) : com.jera.apptemplate.domain.form.validation.BaseValidation {

    override var text: String? = null

    override fun isValid(): Boolean {
        return text?.run { matches(com.jera.apptemplate.domain.form.validation.PhoneNumberValidation.Companion.PHONE_NUMBER_PATTERN.toRegex()) } ?: false
    }

    companion object {
        const val PHONE_NUMBER_PATTERN = "(\\(\\d{2}\\) \\d{5}-\\d{4})"
    }
}