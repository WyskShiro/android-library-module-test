package will.shiro.validatetor.domain.entity.error

import java.io.Serializable

data class Errors(
    val errorMessage: String? = null,
    val errors: ArrayList<String>? = null
) : Serializable