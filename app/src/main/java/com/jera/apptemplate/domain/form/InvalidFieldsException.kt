package com.jera.apptemplate.domain.form

class InvalidFieldsException : Exception() {

    val fieldsValidation = HashSet<String>()
}