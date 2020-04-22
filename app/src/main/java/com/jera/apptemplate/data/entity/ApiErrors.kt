package com.jera.apptemplate.data.entity

import com.google.gson.annotations.SerializedName
import com.jera.apptemplate.domain.entity.error.Errors
import java.io.Serializable
import java.util.*

data class ApiErrors(
    @SerializedName("message")
    val errorMessage: String?,
    @SerializedName("errors")
    val errors: ArrayList<String>?
) : Serializable {
    fun toDomainObject(): Errors {
        return Errors(
            errorMessage = errorMessage,
            errors = errors
        )
    }
}
