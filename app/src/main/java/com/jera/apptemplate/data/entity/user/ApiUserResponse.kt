package com.jera.apptemplate.data.entity.user

import com.google.gson.annotations.SerializedName
import com.jera.apptemplate.data.entity.ApiImage
import com.jera.apptemplate.domain.entity.User
import java.util.*

data class ApiUserResponse(
    @SerializedName("id") val id: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("email") val email: String?,
    @SerializedName("created_at") val createdAt: Date?,
    @SerializedName("updated_at") val updatedAt: Date?,
    @SerializedName("avatar") val avatar: ApiImage?,
    @SerializedName("phone") val phone: String?,
    @SerializedName("token") val token: String?
) {
    fun toDomainObject(): User {
        return User(
            id = id,
            name = name,
            phone = phone,
            email = email,
            token = token,
            avatarUrl = avatar?.medium,
            avatarThumbUrl = avatar?.thumb
        )
    }
}