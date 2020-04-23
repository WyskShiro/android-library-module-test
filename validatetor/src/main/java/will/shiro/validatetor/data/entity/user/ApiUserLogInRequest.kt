package will.shiro.validatetor.data.entity.user

import com.google.gson.annotations.SerializedName
import will.shiro.validatetor.domain.form.user.LoginForm

data class ApiUserLogInRequest(
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String
) {
    companion object {
        fun transform(loginForm: LoginForm): ApiUserLogInRequest {
            return ApiUserLogInRequest(
                email = loginForm.emailValidation.text!!,
                password = loginForm.passwordValidation.text!!
            )
        }
    }
}