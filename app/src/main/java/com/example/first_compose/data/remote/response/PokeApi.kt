package com.example.first_compose.data.remote.response

import com.example.first_compose.data.remote.Pokemon
import com.example.first_compose.data.remote.PokemonX
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokeApi {

    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): PokemonX

    @GET("pokemon/{name}")
    suspend fun getPokemonInf(
        @Path("name") name: String
    ): Pokemon
}