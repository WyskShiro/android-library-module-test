package will.shiro.validatetor.domain.interactors.user

import will.shiro.validatetor.domain.entity.User
import will.shiro.validatetor.domain.util.resource.CURRENT_USER
import will.shiro.validatetor.domain.util.storage.Cache

class GetPersistedUser constructor(private val cache: Cache) {
    fun execute(): User? {
        return try {
            cache.get(CURRENT_USER, User::class.java) as User
        } catch (t: Throwable) {
            null
        }
    }
}
