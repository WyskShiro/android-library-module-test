package will.shiro.validatetor.util.di

import org.koin.dsl.module
import will.shiro.validatetor.domain.boundary.PokemonRepository
import will.shiro.validatetor.domain.interactors.GetPokemon

fun interactorModule() = module {
    single { GetPokemon(get()) }
}