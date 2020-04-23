package will.shiro.validatetor.data.client

import will.shiro.validatetor.data.entity.ApiPokemon
import will.shiro.validatetor.data.util.request.RequestHandler

class ApiClient constructor(
    private val apiService: ApiService
) : RequestHandler() {

    suspend fun getPokemon(id: Long): ApiPokemon? {
        return makeRequest(
            apiService.getPokemon(
                id
            )
        )
    }
}