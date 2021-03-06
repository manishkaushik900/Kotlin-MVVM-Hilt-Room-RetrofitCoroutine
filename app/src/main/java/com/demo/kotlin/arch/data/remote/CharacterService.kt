package com.demo.kotlin.arch.data.remote

import com.demo.kotlin.arch.data.entities.Character
import com.demo.kotlin.arch.data.entities.CharacterList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterService {
    @GET("/api/character")
    suspend fun getAllCharacters() : Response<CharacterList>

    @GET("/api/character/{id}")
    suspend fun getCharacter(@Path("id") id: Int): Response<Character>
}