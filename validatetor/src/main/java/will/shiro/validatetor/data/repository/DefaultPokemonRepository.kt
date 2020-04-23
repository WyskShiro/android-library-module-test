package will.shiro.validatetor.data.repository

import will.shiro.validatetor.data.client.ApiClient
import will.shiro.validatetor.data.entity.ApiPokemonToPokemon
import will.shiro.validatetor.data.util.Exceptions
import will.shiro.validatetor.domain.boundary.PokemonRepository
import will.shiro.validatetor.domain.entity.Pokemon

class DefaultPokemonRepository(
    private val apiClient: ApiClient
) : PokemonRepository {

    override suspend fun getPokemon(id: Long): Pokemon {
        return apiClient.getPokemon(id)?.let(ApiPokemonToPokemon::transform) ?: throw Exceptions.NoObjectReturnedException
    }
}