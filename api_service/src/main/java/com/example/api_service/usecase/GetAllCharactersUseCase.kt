package com.example.api_service.usecase

import com.example.api_service.paging.CharactersPagingDataSource
import com.example.api_service.service.BooksService
import com.example.api_service.service.CharactersService
import com.example.common.ResponseApp
import com.example.common.entity.books.BooksResponseItem
import com.example.common.entity.characters.CharactersResponseItem
import kotlinx.coroutines.flow.flow
import java.lang.Exception

class GetAllCharactersUseCase(private val charactersService: CharactersService) {
    operator fun invoke() = CharactersPagingDataSource.createPager(charactersService,10)
}