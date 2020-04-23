package will.shiro.validatetor.domain.form.user

import will.shiro.validatetor.domain.form.BaseForm
import will.shiro.validatetor.domain.form.validation.*

class SignUpForm : BaseForm() {

    val avatarPathValidation = AvatarPathValidation(false)
    val nameValidation = EmptyValidation()
    val emailValidation = EmailValidation()
    val phoneNumberValidation = PhoneNumberValidation()
    val cpfValidation = CpfValidation()
    val passwordValidation = PasswordValidation()
    private val passwordConfirmationValidation = PasswordConfirmationValidation(passwordValidation)

    override val validationPair = listOf(
        AVATAR_PATH_ID to avatarPathValidation,
        NAME_ID to nameValidation,
        EMAIL_ID to emailValidation,
        PHONE_NUMBER_ID to phoneNumberValidation,
        CPF_ID to cpfValidation,
        PASSWORD_ID to passwordValidation,
        PASSWORD_CONFIRMATION_ID to passwordConfirmationValidation
    )

    companion object {
        const val AVATAR_PATH_ID = "AVATAR_PATH_ID"
        const val NAME_ID = "NAME_ID"
        const val EMAIL_ID = "EMAIL_ID"
        const val PHONE_NUMBER_ID = "PHONE_NUMBER_ID"
        const val CPF_ID = "CPF_ID"
        const val PASSWORD_ID = "PASSWORD_ID"
        const val PASSWORD_CONFIRMATION_ID = "PASSWORD_CONFIRMATION_ID"
    }
}