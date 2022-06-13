package com.example.api_service.usecase

import com.example.api_service.service.BooksService
import com.example.common.ResponseApp
import com.example.common.entity.books.BooksResponse
import com.example.common.entity.books.BooksResponseItem
import kotlinx.coroutines.flow.flow
import java.lang.Exception

class GetAllBooksUseCase(private val booksService: BooksService) {
    operator fun invoke(id:String = "") = flow<ResponseApp<BooksResponse>>{
        emit(ResponseApp.loading())
        val result = booksService.getAllBooks(id)
        if(result.isSuccessful){
            result.body()?.let {
                emit(ResponseApp.success(it))
            }
        }else{
            emit(ResponseApp.errorSystem(Exception("Request is not successful")))
        }
    }
}