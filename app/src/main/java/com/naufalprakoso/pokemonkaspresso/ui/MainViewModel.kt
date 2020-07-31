package com.naufalprakoso.pokemonkaspresso.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.liveData
import androidx.lifecycle.ViewModel
import com.naufalprakoso.pokemonkaspresso.pokemon.PokemonApiRepository
import com.naufalprakoso.pokemonkaspresso.utils.Resource
import kotlinx.coroutines.Dispatchers

class MainViewModel @ViewModelInject constructor(
    private val pokemonApiRepository: PokemonApiRepository
) : ViewModel() {

    fun getData() = liveData(Dispatchers.IO) {

        emit(Resource.loading(data = null))
        try {
            val data = pokemonApiRepository.fetchData()
            emit(Resource.success(data = data))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }

}