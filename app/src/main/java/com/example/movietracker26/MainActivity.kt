package com.example.movietracker26

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.example.movietracker26.ui.theme.MovieTracker26Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieTracker26Theme {
                MyApp(modifier = Modifier.fillMaxSize())
            }
        }
    }
}
