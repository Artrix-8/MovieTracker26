package com.example.movietracker26.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SearchArrayObject(
    @SerialName(value = "Title")
    val title: String,
    @SerialName(value = "Year")
    val year: String,
    val imdbID: String,
    @SerialName(value = "Type")
    val type: String,
    @SerialName(value = "Poster")
    val poster: String
)