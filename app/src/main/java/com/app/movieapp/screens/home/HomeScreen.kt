@file:OptIn(ExperimentalMaterial3Api::class)

package com.app.movieapp.screens.home

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.app.movieapp.model.Movie
import com.app.movieapp.model.getMovies
import com.app.movieapp.navigation.MovieScreens
import com.app.movieapp.widgets.MovieRow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun  HomeScreen(navController: NavController){
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    Color.LightGray
                ),
                title = { Text("My Top Bar") },
            )
        }
    ) { paddingValues ->
        // Content of the screen
        Surface(
            modifier = Modifier.padding(paddingValues),
            color = MaterialTheme.colorScheme.background
        ) {
            MyContent(navController=navController)
        }     }
}

@Composable
fun MyContent(
    navController: NavController,
    movie:List<Movie> = getMovies()){
    Column (modifier = Modifier.padding(20.dp)){
        LazyColumn {
            items(items = movie){
                MovieRow(it){movie->
                    navController.navigate(route = MovieScreens.DetailsScreen.name+ "/$movie")
                    Log.d("TAG","MainContent: $movie")

                }
            }
        }
    }
}