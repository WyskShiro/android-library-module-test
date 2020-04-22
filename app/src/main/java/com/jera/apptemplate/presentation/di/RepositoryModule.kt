package com.jera.apptemplate.presentation.di

import com.jera.apptemplate.data.repository.DefaultUserRepository
import com.jera.apptemplate.domain.boundary.UserRepository
import org.koin.dsl.module

fun repositoryModule() = module {
    single {
        DefaultUserRepository(
            apiClient = get(),
            cache = get()
        ) as UserRepository
    }
}