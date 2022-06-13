package com.example.api_service.service

import com.example.common.entity.houses.HouseResponse
import com.example.common.entity.houses.HouseResponseItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface HousesService {
    @GET("houses/")
    suspend fun getAllHouses(
        @Query("page") page: Int = 1
    ): Response<HouseResponse>

    @GET("houses/{id}")
    suspend fun getOneHouses(
        @Path("id") id: String = ""
    ): Response<HouseResponseItem>
}