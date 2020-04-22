package com.jera.apptemplate.presentation.view.splash

import com.jera.apptemplate.domain.interactors.user.GetPersistedUser
import com.jera.apptemplate.presentation.view.dashboard.DashboardNavData
import com.jera.apptemplate.presentation.view.user.signin.LoginNavData
import com.jera.apptemplate.util.base.BaseViewModel

class SplashViewModel(
    getPersistedUser: GetPersistedUser
) : BaseViewModel() {
    init {
        if (getPersistedUser.execute() == null) {
            goTo(LoginNavData())
        } else {
            goTo(DashboardNavData())
        }
    }
}