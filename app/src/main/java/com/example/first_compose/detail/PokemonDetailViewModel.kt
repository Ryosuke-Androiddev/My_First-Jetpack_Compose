package com.example.first_compose.detail

import androidx.lifecycle.ViewModel
import com.example.first_compose.data.remote.Pokemon
import com.example.first_compose.repository.PokeRepository
import com.example.first_compose.utility.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val repository: PokeRepository
): ViewModel() {

    suspend fun getPokemonInf(pokemonName: String): Resource<Pokemon>{
        return repository.getPokemonInf(pokemonName)
    }
}