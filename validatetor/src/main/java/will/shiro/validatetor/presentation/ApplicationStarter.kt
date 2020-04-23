package will.shiro.validatetor.presentation

import android.content.Context
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import will.shiro.validatetor.util.di.resourceModule
import will.shiro.validatetor.util.di.viewModelsModule

object ApplicationStarter {
    fun start(context: Context) {
        startKoin {
            androidContext(context)
            modules(
                listOf(
                    viewModelsModule(),
                    resourceModule()
                )
            )
        }
    }
}