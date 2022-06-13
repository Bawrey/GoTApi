package com.example.api_service.service

import com.example.common.entity.characters.CharactersResponse
import com.example.common.entity.characters.CharactersResponseItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharactersService {
    @GET("characters/")
    suspend fun getAllCharacters(
        @Query("page") page: Int = 1
    ): Response<CharactersResponse>

    @GET("characters/{id}")
    suspend fun getOneCharacter(
        @Path("id") id: String = ""
    ): Response<CharactersResponseItem>
}