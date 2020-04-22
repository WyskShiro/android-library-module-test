package com.jera.apptemplate.data.client

import com.jera.apptemplate.data.entity.user.ApiUserLogInRequest
import com.jera.apptemplate.data.entity.user.ApiUserResponse
import com.jera.apptemplate.data.entity.user.ApiUserSignUpRequest
import com.jera.apptemplate.data.util.request.MultiPartBodyCreator
import com.jera.apptemplate.data.util.request.RequestHandler
import com.jera.apptemplate.data.util.resources.PLATFORM_CONSTANT

class ApiClient constructor(
    private val apiService: ApiService
) : RequestHandler() {

    suspend fun signIn(apiUserLogInRequest: ApiUserLogInRequest): ApiUserResponse? {
        return makeRequest(
            apiService.signIn(
                apiUserLogInRequest.email,
                apiUserLogInRequest.password,
                PLATFORM_CONSTANT
            )
        )
    }

    suspend fun signUp(apiUserSignUpRequest: ApiUserSignUpRequest): ApiUserResponse? {
        return makeRequest(
            apiService.signUp(MultiPartBodyCreator.execute(apiUserSignUpRequest.toMap()))
        )
    }

    suspend fun recoverPassword(email: String) {
        makeRequest(
            apiService.recoverPassword(email)
        )
    }
}