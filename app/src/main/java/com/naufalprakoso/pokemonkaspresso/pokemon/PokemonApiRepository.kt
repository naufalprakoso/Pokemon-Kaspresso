package com.naufalprakoso.pokemonkaspresso.pokemon

import com.naufalprakoso.pokemonkaspresso.network.ServiceBuilder
import com.naufalprakoso.pokemonkaspresso.network.response.SpeciesResponse
import javax.inject.Inject

class PokemonApiRepository @Inject constructor(
    private val serviceBuilder: ServiceBuilder
) {

    suspend fun fetchData(): List<SpeciesResponse> {
        return serviceBuilder.pokemon.getData().species
    }

}