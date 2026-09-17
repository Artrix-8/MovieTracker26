package com.example.movietracker26.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TitleApiResponse(
    @SerialName(value = "Title")
    val title: String,
    @SerialName(value = "Year")
    val year: String,
    @SerialName(value = "Rated")
    val rated: String
    /**
     * Add other data types if needed
     */
)