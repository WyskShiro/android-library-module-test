package will.shiro.validatetor.data.entity.user

import com.google.gson.annotations.SerializedName
import will.shiro.validatetor.domain.form.user.SignUpForm

data class ApiUserSignUpRequest(
    @SerializedName(NAME) val name: String,
    @SerializedName(PHONE_NUMBER) val phoneNumber: String,
    @SerializedName(CPF) val cpf: String,
    @SerializedName(PASSWORD) val password: String,
    @SerializedName(EMAIL) val email: String,
    @SerializedName(AVATAR) val avatar: String?
) {

    fun toMap(): Map<String, Any?> {
        return mutableMapOf<String, Any?>().apply {
            put(NAME, name)
            put(PHONE_NUMBER, phoneNumber)
            put(CPF, cpf)
            put(PASSWORD, password)
            put(EMAIL, email)
            put(AVATAR, avatar)
        }
    }

    companion object {
        private const val NAME = "name"
        private const val PHONE_NUMBER = "phone_number"
        private const val CPF = "cpf"
        private const val PASSWORD = "password"
        private const val EMAIL = "email"
        private const val AVATAR = "avatar"

        fun transform(form: SignUpForm): ApiUserSignUpRequest {
            return ApiUserSignUpRequest(
                name = form.nameValidation.text!!,
                phoneNumber = form.phoneNumberValidation.text!!,
                cpf = form.cpfValidation.text!!,
                email = form.emailValidation.text!!,
                password = form.passwordValidation.text!!,
                avatar = form.avatarPathValidation.text
            )
        }
    }
}