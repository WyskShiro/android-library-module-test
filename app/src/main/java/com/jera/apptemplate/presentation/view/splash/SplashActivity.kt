package com.jera.apptemplate.presentation.view.splash

import com.jera.apptemplate.util.base.BaseActivity
import com.jera.apptemplate.util.base.BaseViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class SplashActivity : BaseActivity() {

    override val baseViewModel: BaseViewModel get() = localViewModel

    private val localViewModel: SplashViewModel by viewModel()
}
