package com.jera.apptemplate.domain.form.validation

class EmptyValidation(
    override val isRequired: Boolean = true
) : com.jera.apptemplate.domain.form.validation.BaseValidation {

    override var text: String? = null

    override fun isValid(): Boolean {
        return text?.run { isNotBlank() } ?: false
    }
}