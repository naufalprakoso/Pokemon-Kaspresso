package com.naufalprakoso.pokemonkaspresso.network

import com.naufalprakoso.pokemonkaspresso.network.response.PokemonResponse
import retrofit2.http.GET

interface PokemonService {
    @GET("generation/1")
    suspend fun getData(): PokemonResponse
}