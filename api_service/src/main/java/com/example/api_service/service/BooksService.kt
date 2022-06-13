package com.example.api_service.service

import com.example.common.entity.books.BooksResponse
import com.example.common.entity.books.BooksResponseItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BooksService {
    @GET("books/")
    suspend fun getAllBooks(
        @Query("page") page:Int=1
    ): Response<BooksResponse>
    @GET("books/{id}")
    suspend fun getOneBooks(
        @Path("id") id: String = ""
    ): Response<BooksResponseItem>
}