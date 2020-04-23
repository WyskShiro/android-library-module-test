package will.shiro.validatetor.domain.interactors

import will.shiro.validatetor.domain.boundary.PokemonRepository
import will.shiro.validatetor.domain.entity.Pokemon

class GetPokemon constructor(
    private val pokemonRepository: PokemonRepository
) {

    suspend fun execute(id: Long): Pokemon {
        return pokemonRepository.getPokemon(id)
    }
}