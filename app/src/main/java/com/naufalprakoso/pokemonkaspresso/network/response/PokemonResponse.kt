package com.naufalprakoso.pokemonkaspresso.network.response

import com.google.gson.annotations.SerializedName

data class PokemonResponse(
    @SerializedName("pokemon_species")
    val species: List<SpeciesResponse>
)

data class SpeciesResponse(
    val name: String
)