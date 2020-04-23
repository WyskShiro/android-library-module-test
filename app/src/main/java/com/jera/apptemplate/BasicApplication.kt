package com.jera.apptemplate

import android.app.Application
import will.shiro.validatetor.presentation.ApplicationStarter

class BasicApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        ApplicationStarter.start(this, "asasas")
    }
}