package will.shiro.validatetor.domain.boundary

import will.shiro.validatetor.domain.entity.Pokemon

interface PokemonRepository {
    suspend fun getPokemon(id: Long): Pokemon
}