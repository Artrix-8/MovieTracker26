package com.example.movietracker26.data

import com.example.movietracker26.R
import com.example.movietracker26.model.Movie

class Datasource {
    fun loadMovies(): List<Movie> {
        return listOf(
            Movie(R.string.movie1, R.drawable.movie1, true),
            Movie(R.string.movie2, R.drawable.movie2, true),
            Movie(R.string.movie3, R.drawable.movie3, true),
            Movie(R.string.movie4, R.drawable.movie4, false),
            Movie(R.string.movie5, R.drawable.movie5, false)
        )
    }
}