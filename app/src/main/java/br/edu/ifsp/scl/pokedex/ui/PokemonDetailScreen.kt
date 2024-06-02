package br.edu.ifsp.scl.pokedex.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.edu.ifsp.scl.pokedex.model.PokemonDetailResponse
import br.edu.ifsp.scl.pokedex.repository.PokemonRepository
import com.skydoves.landscapist.glide.GlideImage
import kotlinx.coroutines.launch

@Composable
fun PokemonDetailScreen(navController: NavController, pokemonRepository: PokemonRepository, pokemonId: String, imageUrl: String) {
    val coroutineScope = rememberCoroutineScope()
    val pokemonDetail = remember { mutableStateOf<PokemonDetailResponse?>(null) }

    LaunchedEffect(Unit) {
        coroutineScope.launch {
            pokemonDetail.value = pokemonRepository.fetchPokemonDetail(pokemonId)
        }
    }

    pokemonDetail.value?.let { detail ->
        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
            GlideImage(
                imageModel  = imageUrl,
                contentDescription = "Imagem do Pokémon",
                modifier = Modifier.size(100.dp),
            )
            Text(text = detail.name)

            Row() {
                detail.types.map {
                    Text(text = it.type.name, modifier = Modifier.padding(4.dp))

                }
            }

            Text(text = (detail.height / 10.0).toString() + " m")

            Text(text = (detail.weight / 10.0).toString() + " kg")
        }

    }
}