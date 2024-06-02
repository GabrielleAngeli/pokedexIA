package br.edu.ifsp.scl.pokedex.navigation

sealed class Screen(val route: String) {
    object PokemonList : Screen("pokemon_list")
    object PokemonDetail : Screen("pokemon_detail/{pokemonId}") {
        fun withArgs(pokemonId: String): String {
            return "pokemon_detail/$pokemonId"
        }
    }
}