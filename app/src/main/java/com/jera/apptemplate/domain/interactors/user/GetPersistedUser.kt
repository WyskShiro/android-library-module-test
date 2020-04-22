package com.jera.apptemplate.domain.interactors.user

import com.jera.apptemplate.domain.entity.User
import com.jera.apptemplate.domain.util.resource.CURRENT_USER
import com.jera.apptemplate.domain.util.storage.Cache

class GetPersistedUser constructor(private val cache: Cache) {
    fun execute(): User? {
        return try {
            cache.get(CURRENT_USER, User::class.java) as User
        } catch (t: Throwable) {
            null
        }
    }
}
