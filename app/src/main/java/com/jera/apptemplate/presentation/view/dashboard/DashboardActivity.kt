package com.jera.apptemplate.presentation.view.dashboard

import android.content.Context
import android.content.Intent
import com.jera.apptemplate.util.base.BaseActivity
import com.jera.apptemplate.util.base.BaseViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class DashboardActivity : BaseActivity() {
    override val baseViewModel: BaseViewModel
        get() = localViewModel

    private val localViewModel: DashboardViewModel by viewModel()

    companion object {
        fun createIntent(context: Context): Intent {
            return Intent(context, DashboardActivity::class.java)
        }
    }
}