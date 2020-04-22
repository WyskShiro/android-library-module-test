package com.jera.apptemplate.presentation.di

import com.jera.apptemplate.domain.interactors.user.GetPersistedUser
import com.jera.apptemplate.domain.interactors.user.LogIn
import com.jera.apptemplate.domain.interactors.user.RecoverPassword
import com.jera.apptemplate.domain.interactors.user.SignUp
import org.koin.dsl.module

fun interactorModule() = usersInteractor()

private fun usersInteractor() = module {
    single {
        GetPersistedUser(
            cache = get()
        )
    }

    single {
        LogIn(
            repository = get()
        )
    }

    single {
        RecoverPassword(
            repository = get()
        )
    }

    single {
        SignUp(
            repository = get()
        )
    }
}