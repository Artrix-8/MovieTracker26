package com.example.movietracker26

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movietracker26.data.Datasource
import com.example.movietracker26.model.Movie
import com.example.movietracker26.ui.theme.MovieTracker26Theme

enum class MovieScreen {
    Movies,
    Watchlist,
    Description
}

@Composable
fun MyApp(modifier: Modifier = Modifier) {
    Surface(modifier, color = MaterialTheme.colorScheme.background) {
        MovieList(
            movieList = Datasource().loadMovies(),
        )
    }
}

@Composable
private fun MovieList(movieList: List<Movie>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier.padding(vertical = 4.dp)) {
        items(movieList) { movie ->
            if(movie.watchlist) {
                MovieCard(movie = movie)
            }
        }
    }
}

@Composable
private fun MovieCard(movie: Movie, modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(false) }
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        modifier = modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(24.dp)
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                )
        ) {
            Column(modifier = Modifier.weight(1f).padding(12.dp)) {
                Image(
                    painter = painterResource(movie.imageResourceId),
                    contentDescription = stringResource(movie.stringResourceId),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(194.dp),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = stringResource(movie.stringResourceId),
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.headlineSmall
                )
                if (expanded) {
                    Text(text = ("Compose ipsum color sit lazy, " +
                            "padding theme elit, sed do bouncy. ").repeat(4),
                    )
                }
                ElevatedButton(
                    onClick = { expanded = !expanded }
                ) {
                    Text(if (expanded) "Hide description" else "Show description")
                }
            }
        }
    }
}

@Preview(
    showBackground = true,
    widthDp = 320,
    uiMode = UI_MODE_NIGHT_YES,
    name = "MoviePreviewDark"
)
@Preview(showBackground = true, widthDp = 320)
@Composable
fun MoviePreview() {
    MovieTracker26Theme {
        MovieCard(Movie(R.string.movie1, R.drawable.movie1, true))
    }
}

@Preview
@Composable
fun MyAppPreview() {
    MovieTracker26Theme {
        MyApp(Modifier.fillMaxSize())
    }
}