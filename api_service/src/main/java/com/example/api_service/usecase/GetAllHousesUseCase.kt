package com.example.api_service.usecase

import com.example.api_service.service.HousesService
import com.example.common.ResponseApp
import com.example.common.entity.houses.HouseResponseItem
import kotlinx.coroutines.flow.flow
import java.lang.Exception

class GetAllHousesUseCase(private val housesService: HousesService) {
    operator fun invoke(id: String = "") = flow<ResponseApp<HouseResponseItem>> {
        emit(ResponseApp.loading())
        val result = housesService.getAllHouses(id)
        if (result.isSuccessful) {
            result.body()?.let {
                emit(ResponseApp.success(it))
            }
        } else {
            emit(ResponseApp.errorSystem(Exception("Request is not successful")))
        }
    }
}