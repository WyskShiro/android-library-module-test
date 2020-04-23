package will.shiro.validatetor.domain.form

class InvalidFieldsException : Exception() {

    val fieldsValidation = HashSet<String>()
}