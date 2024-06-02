package br.edu.ifsp.scl.pokedex.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.edu.ifsp.scl.pokedex.model.Pokemon

@Composable
fun PokemonList(pokemons: List<Pokemon>, onItemClick: (Pokemon) -> Unit) {
    LazyVerticalGrid(
        modifier = Modifier.fillMaxSize(),
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(6.dp),
    ) {
        items(items = pokemons) { pokemon ->
            PokemonCard(pokemon, onPokemonClick = {onItemClick(pokemon)})
        }
    }
}