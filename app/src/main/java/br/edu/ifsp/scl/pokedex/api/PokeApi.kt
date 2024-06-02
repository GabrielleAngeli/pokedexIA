package br.edu.ifsp.scl.pokedex.api

import br.edu.ifsp.scl.pokedex.model.PokemonDetailResponse
import retrofit2.http.GET
import br.edu.ifsp.scl.pokedex.model.PokemonResponse
import retrofit2.http.Path
import retrofit2.http.Query

interface PokeApi {
    @GET("pokemon")
    suspend fun getPokemons(@Query("limit") limit: Int, @Query("offset") offset: Int): PokemonResponse


    @GET("pokemon/{id}")
    suspend fun getPokemonDetail(@Path("id") id: String): PokemonDetailResponse

}