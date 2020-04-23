package will.shiro.validatetor.domain.form.validation

interface BaseValidation {

    val isRequired: Boolean
    var text: String?

    fun isValid(): Boolean
}