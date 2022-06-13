package com.example.api_service.paging

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.api_service.service.BooksService
import com.example.api_service.service.CharactersService
import com.example.common.entity.books.BooksResponseItem
import com.example.common.entity.characters.CharactersResponseItem

class BooksPagingDataSource(
    private val booksService: BooksService
) :
    PagingSource<Int, BooksResponseItem>() {
    override fun getRefreshKey(state: PagingState<Int, BooksResponseItem>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, BooksResponseItem> {
        return try {
            val page = params.key ?: 1
            val prevKey = if (page == 1) null else page - 1
            val result = booksService.getAllBooks(page = page)
            if (result.isSuccessful) {
                result.body()?.let {
                    val nextKey = if (it.isEmpty()) null else page + 1
                    LoadResult.Page(data = it.toList(), prevKey = prevKey, nextKey = nextKey)
                } ?: kotlin.run {
                    LoadResult.Error(Exception("Data is empty: " + result.message()))
                }
            } else {
                LoadResult.Error(Exception("Result is not successful: " + result.message()))
            }
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    companion object {
        fun createPager(
            booksService: BooksService,
            pageSize: Int
        ): Pager<Int, BooksResponseItem> = Pager(config = PagingConfig(pageSize), pagingSourceFactory = {
            BooksPagingDataSource(booksService)
        })
    }
}