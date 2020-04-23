package will.shiro.validatetor.data.util.formatter

import com.google.gson.Gson
import will.shiro.validatetor.data.entity.ApiErrors
import okhttp3.ResponseBody

object ApiErrorsFormatter {
    fun deserialize(responseBody: ResponseBody?): ApiErrors? = Gson().fromJson(responseBody?.string(), ApiErrors::class.java)
}