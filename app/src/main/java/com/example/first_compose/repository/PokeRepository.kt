package com.example.first_compose.repository

import com.example.first_compose.data.remote.Pokemon
import com.example.first_compose.data.remote.PokemonX
import com.example.first_compose.data.remote.response.PokeApi
import com.example.first_compose.utility.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class PokeRepository @Inject constructor(
    private val api: PokeApi
){

    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonX>{
        val response = try {
            api.getPokemonList(limit,offset)
        } catch (e:Exception){
            return Resource.Error("Error occurred!")
        }
        return Resource.Success(response)
    }

    suspend fun getPokemonInf(pokemonName: String): Resource<Pokemon>{
        val response = try {
            api.getPokemonInf(pokemonName)
        } catch (e:Exception){
            return Resource.Error("Error occurred!")
        }
        return Resource.Success(response)
    }

}