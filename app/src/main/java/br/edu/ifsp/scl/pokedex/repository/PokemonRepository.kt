package br.edu.ifsp.scl.pokedex.repository

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import br.edu.ifsp.scl.pokedex.api.PokeApi
import br.edu.ifsp.scl.pokedex.model.Pokemon
import br.edu.ifsp.scl.pokedex.model.PokemonDetailResponse

class PokemonRepository {
    private val service: PokeApi = Retrofit.Builder()
        .baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(PokeApi::class.java)

    suspend fun fetchPokemons(limit: Int, offset: Int): List<Pokemon> {
        return service.getPokemons(limit, offset).results
    }

    suspend fun fetchPokemonDetail(id: String): PokemonDetailResponse {
        return service.getPokemonDetail(id)
    }
}