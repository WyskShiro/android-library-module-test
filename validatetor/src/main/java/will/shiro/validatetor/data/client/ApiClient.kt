package will.shiro.validatetor.data.client

import will.shiro.validatetor.data.entity.user.ApiUserLogInRequest
import will.shiro.validatetor.data.entity.user.ApiUserResponse
import will.shiro.validatetor.data.entity.user.ApiUserSignUpRequest
import will.shiro.validatetor.data.util.request.MultiPartBodyCreator
import will.shiro.validatetor.data.util.request.RequestHandler
import will.shiro.validatetor.data.util.resources.PLATFORM_CONSTANT

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