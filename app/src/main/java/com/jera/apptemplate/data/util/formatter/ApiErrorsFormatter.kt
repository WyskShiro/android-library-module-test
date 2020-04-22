package com.jera.apptemplate.data.util.formatter

import com.google.gson.Gson
import com.jera.apptemplate.data.entity.ApiErrors
import okhttp3.ResponseBody

object ApiErrorsFormatter {
    fun deserialize(responseBody: ResponseBody?): ApiErrors? = Gson().fromJson(responseBody?.string(), ApiErrors::class.java)
}