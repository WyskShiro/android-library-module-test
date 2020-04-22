package com.jera.apptemplate.domain.form.validation

interface BaseValidation {

    val isRequired: Boolean
    var text: String?

    fun isValid(): Boolean
}