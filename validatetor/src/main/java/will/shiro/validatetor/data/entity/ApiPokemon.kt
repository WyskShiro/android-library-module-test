package will.shiro.validatetor.data.entity

import com.google.gson.annotations.SerializedName
import will.shiro.validatetor.data.util.mapper.Mapper
import will.shiro.validatetor.domain.entity.Pokemon

data class ApiPokemon(
    @SerializedName("base_experience") val baseExperience: Long?,
    @SerializedName("weight") val weight: Long?
)

object ApiPokemonToPokemon: Mapper<ApiPokemon, Pokemon>() {
    override fun transform(t: ApiPokemon): Pokemon {
        return Pokemon(
            baseExperience = t.baseExperience ?: 0,
            weight = t.weight ?: 0
        )
    }
}