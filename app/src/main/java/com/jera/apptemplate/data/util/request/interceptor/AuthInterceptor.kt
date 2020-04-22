package com.jera.apptemplate.data.util.request.interceptor

import com.jera.apptemplate.domain.util.storage.Cache
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor constructor(private val cache: Cache) : Interceptor {

    companion object {
        const val USER_TOKEN = "USER_TOKEN"
        const val USER_EMAIL = "USER_EMAIL"
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()
        try {
            requestBuilder.addHeader(USER_TOKEN, getTokenFromCache())
            requestBuilder.addHeader(USER_EMAIL, getEmailFromCache())
        } catch (e: Cache.NotFoundException) {
            /* Nothing to do here */
        }

        val response = chain.proceed(requestBuilder.build())
        response.headers().get(USER_TOKEN)?.let { cache.set(USER_TOKEN, it) }
        response.headers().get(USER_EMAIL)?.let { cache.set(USER_EMAIL, it) }
        return response
    }

    private fun getEmailFromCache() = cache.get<String>(USER_EMAIL, String::class.java)
    private fun getTokenFromCache() = cache.get<String>(USER_TOKEN, String::class.java)
}