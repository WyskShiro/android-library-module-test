package com.jera.apptemplate.presentation.view.user.signin

import com.jera.apptemplate.domain.form.user.LoginForm
import com.jera.apptemplate.domain.interactors.user.LogIn
import com.jera.apptemplate.presentation.view.dashboard.DashboardNavData
import com.jera.apptemplate.util.base.BaseViewModel

class LogInViewModel constructor(
    private val logIn: LogIn
) : BaseViewModel() {

    fun onFacebookButtonClicked() {}

    fun onGoogleButtonClicked() {}

    private fun onSuccess() {
        goTo(
            DashboardNavData(clearTask = true)
        )
    }
}