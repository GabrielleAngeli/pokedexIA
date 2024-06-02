package br.edu.ifsp.scl.pokedex.model


import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Pokemon(
    val name: String,
    val url: String,
    val details: String
): Parcelable {

//    val name: String
//        get() = nameField.replaceFirstChar { it.uppercase() }

    val id: String  get() {
        return url.split("/".toRegex()).dropLast(1).last()
    }

    val imageUrl: String
        get() {
            val index = url.split("/".toRegex()).dropLast(1).last()
            return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$index.png"
        }
}