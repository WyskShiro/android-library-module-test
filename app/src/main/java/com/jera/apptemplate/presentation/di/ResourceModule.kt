package com.jera.apptemplate.presentation.di

import com.jera.apptemplate.data.util.storage.PreferencesCache
import com.jera.apptemplate.domain.util.logger.Logger
import com.jera.apptemplate.domain.util.resource.Strings
import com.jera.apptemplate.domain.util.storage.Cache
import com.jera.apptemplate.util.error.ErrorHandler
import com.jera.apptemplate.util.logger.AndroidLogger
import com.jera.apptemplate.util.resource.AndroidStrings
import com.jera.apptemplate.util.resource.NAME_LOGIN_ACTION
import org.koin.core.qualifier.named
import org.koin.dsl.module

fun resourceModule() = module {
    single {
        AndroidStrings(
            context = get()
        ) as Strings
    }

    single {
        AndroidLogger(
            context = get()
        ) as Logger
    }

    single {
        PreferencesCache() as Cache
    }

    single {
        ErrorHandler(
            strings = get(),
            logger = get(),
            loginAction = get(named(NAME_LOGIN_ACTION))
        )
    }
}