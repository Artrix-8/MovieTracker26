package com.example.movietracker26.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SearchApiResponse(
    @SerialName(value = "Search")
    val search: List<SearchArrayObject>,
    val totalResults: String,
    @SerialName(value = "Response")
    val response: String
)
