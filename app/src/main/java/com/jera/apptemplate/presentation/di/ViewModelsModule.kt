package com.jera.apptemplate.presentation.di

import com.jera.apptemplate.presentation.view.dashboard.DashboardViewModel
import com.jera.apptemplate.presentation.view.splash.SplashViewModel
import com.jera.apptemplate.presentation.view.user.signin.LogInViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

fun viewModelsModule() = module {
    viewModel {
        DashboardViewModel()
    }

    viewModel {
        LogInViewModel(
            logIn = get()
        )
    }

    viewModel {
        SplashViewModel(
            getPersistedUser = get()
        )
    }
}