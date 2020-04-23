package will.shiro.validatetor.util.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import will.shiro.validatetor.presentation.view.dashboard.DashboardViewModel

fun viewModelsModule() = module {
    viewModel {
        DashboardViewModel(get())
    }
} 