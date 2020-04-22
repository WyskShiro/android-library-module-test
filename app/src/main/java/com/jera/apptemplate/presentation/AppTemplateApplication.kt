package com.jera.apptemplate.presentation

import android.app.Application
import com.jera.apptemplate.data.util.storage.PreferencesCache
import com.jera.apptemplate.presentation.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AppTemplateApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        PreferencesCache.init(this)
        startKoin {
            androidContext(this@AppTemplateApplication)
            modules(
                listOf(
                    networkingModule(),
                    viewModelsModule(),
                    resourceModule(),
                    interactorModule(),
                    repositoryModule(),
                    functionModule()
                )
            )
        }
    }
}
