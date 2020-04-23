package will.shiro.validatetor.util.di

import io.reactivex.schedulers.Schedulers.single
import org.koin.core.qualifier.named
import org.koin.dsl.module
import will.shiro.validatetor.domain.util.logger.Logger
import will.shiro.validatetor.domain.util.resource.Strings
import will.shiro.validatetor.util.error.ErrorHandler
import will.shiro.validatetor.util.logger.AndroidLogger
import will.shiro.validatetor.util.resource.AndroidStrings
import will.shiro.validatetor.util.resource.NAME_LOGIN_ACTION

fun resourceModule() = module {
    single {
        AndroidStrings(
            context = get()
        ) as Strings
    }

    single {
        AndroidLogger(
            context = get()
        ) as Logger
    }

    single {
        ErrorHandler(
            strings = get(),
            logger = get(),
            loginAction = get(named(NAME_LOGIN_ACTION))
        )
    }
}