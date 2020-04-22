package com.jera.apptemplate.presentation.view.dashboard

import android.content.Context
import com.jera.apptemplate.util.extension.shouldClearTask
import com.jera.apptemplate.util.navigation.NavData

class DashboardNavData(private val clearTask: Boolean = true) : NavData {
    override fun navigate(context: Context) {
        context.startActivity(
            DashboardActivity.createIntent(context).shouldClearTask(clearTask)
        )
    }
}