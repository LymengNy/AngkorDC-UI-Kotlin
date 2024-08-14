package com.example.finalproject.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import kotlin.math.min
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TextField
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.finalproject.models.MovieModel
import com.example.finalproject.models.movieList

@Composable
fun SearchPage(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize() // Fill the entire available space

            .background(color = Color.Black) // Set the background color of the entire page to black
    ) {
        // Add your search box here
        SearchBox(navController)
    }
}

@Composable
fun SearchBox(navController: NavController) {
    var text by remember { mutableStateOf("") }
    var searchedMovies: List<MovieModel> by remember { mutableStateOf(emptyList()) }

    // Define the background color for the search box


    TextField(
        value = text,
        onValueChange = { newText ->
            text = newText
            searchedMovies = searchMoviesByTitle(newText)
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .background(color = Color.Gray) , // Apply background color here
        leadingIcon = {
            Icon(Icons.Filled.Search, contentDescription = "Search")
        },
        trailingIcon = {
            if (text.isNotEmpty()) {
                IconButton(
                    onClick = { text = "" }
                ) {
                    Icon(Icons.Filled.Clear, contentDescription = "Clear")
                }
            }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Search
        ),
        keyboardActions = KeyboardActions(
            onSearch = {
                // Perform search operations here if needed
                searchedMovies = searchMoviesByTitle(text)
            }
        )
    )

    // Display searched movies in rows with three columns
    Column(modifier = Modifier.fillMaxWidth()) {
        val numberOfRows = (searchedMovies.size + 2) / 3
        repeat(numberOfRows) { rowIndex ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                val startIndex = rowIndex * 3
                for (i in startIndex until min(startIndex + 3, searchedMovies.size)) {
                    Box(
                        modifier = Modifier.padding(8.dp) // Adjust padding as needed
                    ) {
                        // Make the Image clickable and navigate to detail page
                        Image(
                            painter = rememberImagePainter(searchedMovies[i].image),
                            contentDescription = null,
                            modifier = Modifier
                                .size(128.dp)
                                .clickable {
                                    val selectedMovie = searchedMovies[i]
                                    navController.navigate("movieDetail/${selectedMovie.id}")
                                }
                        )
                    }
                }
            }
        }
    }
}


fun searchMoviesByTitle(title: String): List<MovieModel> {
    return movieList.filter { it.title.contains(title, ignoreCase = true) }
}
