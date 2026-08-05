package com.example.movietracker26.data

import com.example.movietracker26.R
import com.example.movietracker26.model.Movie

class Datasource() {
    fun loadMovies(): List<Movie> {
        return listOf<Movie>(
            Movie(R.string.movie1, R.drawable.movie1),
            Movie(R.string.movie2, R.drawable.movie2),
            Movie(R.string.movie3, R.drawable.movie3),
            Movie(R.string.movie4, R.drawable.movie4),
            Movie(R.string.movie5, R.drawable.movie5)
        )
    }
}