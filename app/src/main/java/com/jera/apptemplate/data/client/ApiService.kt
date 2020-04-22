package com.jera.apptemplate.data.client

import com.jera.apptemplate.data.entity.user.ApiUserResponse
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {

    @FormUrlEncoded
    @POST("users/sign_in")
    suspend fun signIn(
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("platform") platform: String
    ): Response<ApiUserResponse>

    @POST("users/sign_up")
    suspend fun signUp(@Body requestBody: RequestBody): Response<ApiUserResponse>

    @FormUrlEncoded
    @POST("users/recover_password")
    suspend fun recoverPassword(@Field("email") email: String): Response<Void>
}