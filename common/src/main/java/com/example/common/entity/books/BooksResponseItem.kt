package com.example.common.entity.books


import com.google.gson.annotations.SerializedName

data class BooksResponseItem(
    @SerializedName("authors")
    val authors: List<String>,
    @SerializedName("characters")
    val characters: List<String>,
    @SerializedName("country")
    val country: String,
    @SerializedName("isbn")
    val isbn: String,
    @SerializedName("mediaType")
    val mediaType: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("numberOfPages")
    val numberOfPages: Int,
    @SerializedName("povCharacters")
    val povCharacters: List<Any>,
    @SerializedName("publisher")
    val publisher: String,
    @SerializedName("released")
    val released: String,
    @SerializedName("url")
    val url: String
)