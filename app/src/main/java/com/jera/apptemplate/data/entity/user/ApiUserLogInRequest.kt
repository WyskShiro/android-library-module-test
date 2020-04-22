package com.jera.apptemplate.data.entity.user

import com.google.gson.annotations.SerializedName
import com.jera.apptemplate.domain.form.user.LoginForm

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