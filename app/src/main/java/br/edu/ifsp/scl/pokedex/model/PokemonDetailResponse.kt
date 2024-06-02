package br.edu.ifsp.scl.pokedex.model

data class PokemonDetailResponse(
    val name: String,
    val weight: Int,
    val height: Int,
    val types: List<PokemonType>
)

data class PokemonType(
    val slot: Int,
    val type: TypeDetail
)

data class TypeDetail(
    val name: String
)