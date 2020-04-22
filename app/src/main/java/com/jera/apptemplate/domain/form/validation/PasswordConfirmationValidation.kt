package com.jera.apptemplate.domain.form.validation

class PasswordConfirmationValidation(
    private val passwordValidation: com.jera.apptemplate.domain.form.validation.PasswordValidation,
    override val isRequired: Boolean = true
) : com.jera.apptemplate.domain.form.validation.BaseValidation {

    override var text: String? = null

    override fun isValid(): Boolean {
        return passwordValidation.isValid() && text == passwordValidation.text
    }
}