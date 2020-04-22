package com.jera.apptemplate.presentation.view.user.signin

import android.content.Context
import com.jera.apptemplate.util.extension.shouldClearTask
import com.jera.apptemplate.util.navigation.NavData

class LoginNavData(private val clearTask: Boolean = true) : NavData {
    override fun navigate(context: Context) {
        context.startActivity(
            LogInActivity.createIntent(context)
                .shouldClearTask(clearTask)
        )
    }
}