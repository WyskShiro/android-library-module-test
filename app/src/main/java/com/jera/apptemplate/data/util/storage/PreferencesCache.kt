package com.jera.apptemplate.data.util.storage

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.jera.apptemplate.domain.util.storage.Cache
import java.lang.reflect.Type

class PreferencesCache : Cache {

    companion object {

        const val PREFS_NAME = "APP_PREFERENCES"

        lateinit var sharedPreferences: SharedPreferences
            private set

        fun init(context: Context) {
            sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        }
    }

    private val gson = Gson()

    override fun <T> get(key: String, type: Type): T {
        val stringValue = sharedPreferences.getString(key, null) ?: throw Cache.NotFoundException()
        return gson.fromJson(stringValue, type) ?: throw Cache.NotFoundException()
    }

    override fun set(key: String, value: Any?) {
        if (value == null) {
            sharedPreferences.edit().remove(key).apply()
        } else {
            sharedPreferences.edit().putString(key, gson.toJson(value)).apply()
        }
    }

    override fun clear() {
        sharedPreferences.edit().clear().apply()
    }
}
