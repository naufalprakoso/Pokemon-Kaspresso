package com.naufalprakoso.pokemonkaspresso.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ServiceBuilder {
    private val baseUrl: String = "https://pokeapi.co/api/v2/"

    private val retrofitBuilder: Retrofit.Builder by lazy {
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
    }

    val pokemon by lazy {
        retrofitBuilder.build().create(PokemonService::class.java)
    }
}