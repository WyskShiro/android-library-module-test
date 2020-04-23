package will.shiro.validatetor.data.entity

import com.google.gson.annotations.SerializedName
import will.shiro.validatetor.domain.entity.error.Errors
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
