package com.jera.apptemplate.domain.form.validation

class PasswordValidation(
    override val isRequired: Boolean = true
) : com.jera.apptemplate.domain.form.validation.BaseValidation {

    override var text: String? = null

    override fun isValid(): Boolean {
        return text?.run { length >= com.jera.apptemplate.domain.form.validation.PasswordValidation.Companion.MIN_PASSWORD_LENGTH } ?: false
    }

    companion object {
        const val MIN_PASSWORD_LENGTH = 6
    }
}