package will.shiro.validatetor.data.client

import retrofit2.Response
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import will.shiro.validatetor.data.entity.ApiPokemon

interface ApiService {

    @GET("pokemon/{id}")
    suspend fun getPokemon(
        @Path("id") id: Long
    ): Response<ApiPokemon>
}