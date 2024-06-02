package br.edu.ifsp.scl.pokedex.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.edu.ifsp.scl.pokedex.model.Pokemon
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun PokemonCard(pokemon: Pokemon, onPokemonClick: (Pokemon) -> Unit) {

    Card(
        modifier = Modifier
            .padding(6.dp)
            .clickable { onPokemonClick(pokemon) },
    ) {
            GlideImage(
                imageModel  = pokemon.imageUrl,
                contentDescription = "Imagem do Pokémon",
                modifier = Modifier.size(100.dp)
                    .align(Alignment.CenterHorizontally),
            )
            Text(text = pokemon.name, modifier = Modifier.padding(start = 8.dp).align(Alignment.CenterHorizontally))
    }
}