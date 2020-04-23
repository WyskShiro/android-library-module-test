package will.shiro.validatetor.util.di

import org.koin.dsl.module
import will.shiro.validatetor.data.repository.DefaultPokemonRepository
import will.shiro.validatetor.domain.boundary.PokemonRepository

fun repositoryModule() = module {
    single { DefaultPokemonRepository(get()) as PokemonRepository }
}