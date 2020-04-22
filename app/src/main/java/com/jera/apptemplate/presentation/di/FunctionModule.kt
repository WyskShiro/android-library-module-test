package com.jera.apptemplate.presentation.di

import android.content.Context
import com.jera.apptemplate.domain.util.storage.Cache
import com.jera.apptemplate.presentation.view.user.signin.LogInActivity
import com.jera.apptemplate.util.resource.NAME_LOGIN_ACTION
import org.koin.core.qualifier.named
import org.koin.dsl.module

fun functionModule() = module {
    single(named(NAME_LOGIN_ACTION)) {
        loginAction(
            context = get(),
            cache = get()
        )
    }
}

private fun loginAction(context: Context, cache: Cache): () -> Unit {
    return {
        cache.clear()
        context.startActivity(LogInActivity.createIntent(context))
    }
}