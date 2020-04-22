package com.jera.apptemplate.domain.form

import com.jera.apptemplate.domain.form.validation.BaseValidation

abstract class BaseForm {

    abstract val validationPair: List<Pair<String, BaseValidation>>

    val exception: InvalidFieldsException get() = invalidFieldsException
    var isFilled = false

    private val invalidFieldsException: InvalidFieldsException = InvalidFieldsException()

    fun setFormItem(itemId: String, text: String) {
        var isFilled = true
        validationPair.forEach { (id, validation) ->
            if (itemId == id) validation.text = text
            if (validation.isRequired && validation.text.isNullOrEmpty()) isFilled = false
        }
        this.isFilled = isFilled
    }

    fun isValid(): Boolean {
        validate()
        return invalidFieldsException.fieldsValidation.isEmpty()
    }

    private fun validate() {
        validationPair.forEach {
            addField(it.first, if (it.second.isRequired) it.second.isValid() else true)
        }
    }

    private fun addField(field: String, valid: Boolean) {
        if (valid) {
            invalidFieldsException.fieldsValidation.remove(field)
        } else {
            invalidFieldsException.fieldsValidation.add(field)
        }
    }
}