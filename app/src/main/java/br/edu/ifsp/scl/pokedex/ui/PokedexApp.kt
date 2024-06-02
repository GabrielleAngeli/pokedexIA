package br.edu.ifsp.scl.pokedex.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.edu.ifsp.scl.pokedex.model.Pokemon
import br.edu.ifsp.scl.pokedex.navigation.Screen
import br.edu.ifsp.scl.pokedex.repository.PokemonRepository
import kotlinx.coroutines.launch

@Composable
fun PokedexApp() {
    val coroutineScope = rememberCoroutineScope()
    val pokemons = remember { mutableStateOf(listOf<Pokemon>()) }
    val pokemonRepository = PokemonRepository()
    val navController = rememberNavController()
    var pokemonImage = remember { mutableStateOf("") }
    val limit = 20
    var offset by remember { mutableStateOf(0) }

    LaunchedEffect(Unit) {
        coroutineScope.launch {
            // Buscar os primeiros 20 pokémons
            pokemons.value = pokemonRepository.fetchPokemons(limit, offset)
            // Atualizar o offset para buscar a próxima página
            offset += limit
            // Buscar os próximos 20 pokémons
            pokemons.value += pokemonRepository.fetchPokemons(limit, offset)
        }
    }

    NavHost(navController, startDestination = Screen.PokemonList.route) {
        composable(Screen.PokemonList.route) {
            PokemonList(pokemons.value){ pokemon ->
                pokemonImage.value = pokemon.imageUrl
                navController.navigate(Screen.PokemonDetail.withArgs(pokemon.id))

            }
        }
        composable(Screen.PokemonDetail.route) { backStackEntry ->
            val pokemonId = backStackEntry.arguments?.getString("pokemonId")
            if (pokemonId != null) {
                PokemonDetailScreen(navController, pokemonRepository, pokemonId, imageUrl = pokemonImage.value )
            }
        }
    }
}