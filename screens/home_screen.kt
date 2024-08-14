package com.example.finalproject.screens


import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.QrCodeScanner
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.LibraryAdd
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.example.finalproject.models.MovieModel
import com.example.finalproject.models.movieList
import kotlin.math.min


import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.finalproject.models.videoList

val PromotionList = listOf<String>(
    "https://admin.angkordc.com/uploads/movie/1671762974-coming%20soon.jpg",
)
@Preview(showSystemUi = true)
@Composable
fun PreviewHome(){
    HomeScreen()
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen() {
    val movies = remember { movieList }
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { composeBottomAppBar(navController = navController) },
    ) {
        NavHost(navController = navController, startDestination = "home") {
            composable("home") {
                Homepage(navController = navController)
            }
            composable("coming_soon") {
                ComingSoonPage(navController = navController)
            }
            composable("search") {
                SearchPage(navController = navController)
            }
            composable("notification") {
                NotificationPage(navController = navController)
            }
            composable(
                route = "movieDetail/{movieId}",
                arguments = listOf(navArgument("movieId") { type = NavType.IntType })
            ) { backStackEntry ->
                val movieId = backStackEntry.arguments?.getInt("movieId")
                val selectedMovie = movies.find { it.id == movieId }
                selectedMovie?.let { MovieDetailScreen(selectedMovie, navController) }
            }
            composable("User") {
                Userpage(navController = navController)
            }
            composable("watch") {
                WatchPage(navController = navController)
            }

            composable("download") {
                DownlaodPage(navController = navController)
            }
            composable("Library") {
                PurchPage(navController = navController)
            }

        }
    }
}


@Composable
fun Homepage(navController: NavController) {
    Scaffold(
        topBar = { composeTopBar(navController = navController) },
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .background(Color.Black)
                .padding(bottom = it.calculateBottomPadding()) // Adjust padding for bottom bar
        ) {
            composeStory()
            composePostColumn(movieList, navController) // Pass the NavController here
        }
    }
}


@Composable
fun composeBottomAppBar(navController: NavController) {
    BottomAppBar(
        modifier = Modifier.background(
            Brush.horizontalGradient(
                colors = listOf(Color.Black, Color.Black)
            )
        ),
        containerColor = Color.Transparent,
        contentColor = Color.White,
        content = {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                IconButton(
                    onClick = {
                        navController.navigate("home")
                    }
                ) {
                    Icon(Icons.Rounded.Home, contentDescription = "Home")
                }
                Text("Home", color = Color.White)
            }
            Spacer(modifier = Modifier.width(60.dp))
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                IconButton(
                    onClick = {
                        navController.navigate("search")
                    }
                ) {
                    Icon(Icons.Rounded.Search, contentDescription = "Search")
                }
                Text("Search", color = Color.White)
            }
            Spacer(modifier = Modifier.width(60.dp))
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                IconButton(
                    onClick = {
                        navController.navigate("coming_soon")
                    }
                ) {
                    Icon(Icons.Rounded.Person, contentDescription = "coming_soon")
                }
                Text("Notification", color = Color.White)
            }
            Spacer(modifier = Modifier.width(60.dp))
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                IconButton(
                    onClick = {
                        navController.navigate("Library")
                    }
                ) {
                    Icon(Icons.Rounded.LibraryAdd, contentDescription = "Library")
                }
                Text("Library", color = Color.White)
            }
        }
    )
}















@Composable
fun composeStory() {
    Column {
        PromotionList.forEach { promotion ->
            Box(
                modifier = Modifier

                    .height(300.dp)
                    .fillMaxWidth()
            ) {
                Image(
                    painter = rememberImagePainter(promotion),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
                Row(
                    modifier = Modifier
                        .padding(vertical = 3.dp)
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Button(
                        onClick = { /* Play now button clicked */ },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Yellow
                        )
                    ) {
                        Icon(Icons.Default.PlayArrow, contentDescription = "Play Now",tint = Color.Black)
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("Play Now", color = Color.Black)
                    }

                    Spacer(modifier = Modifier.width(8.dp))

                    Button(
                        onClick = { /* Download button clicked */ },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White
                        )
                    ) {
                        Icon(Icons.Default.Download, contentDescription = "Download",tint = Color.Black)
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("Download", color = Color.Black)
                    }
                }
            }
        }
    }
}

@Composable
fun composePostColumn(movies: List<MovieModel>, navController: NavController) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        val numberOfRows = (movies.size + 2) / 3
        repeat(numberOfRows) { rowIndex ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                val startIndex = rowIndex * 3
                val endIndex = min(startIndex + 3, movies.size)

                for (i in startIndex until endIndex) {
                    Box(
                        modifier = Modifier
                            .padding(2.dp)
                            .weight(1f)
                            .clickable {
                                val selectedMovie = movies[i]
                                navController.navigate("movieDetail/${selectedMovie.id}")
                            }
                    ) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.Bottom,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = rememberImagePainter(movies[i].image),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .size(150.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

val images = movieList.map { it.image }



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun composeTopBar(navController: NavController) {
    TopAppBar(
        title = { Text("Jane") },
        modifier = Modifier,
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Black,
            titleContentColor = Color.White,
            navigationIconContentColor = Color.White,
            actionIconContentColor = Color.White,
        ),
        navigationIcon = {
            Image(
                painter = rememberImagePainter("https://www.angkordc.com/image/logo/logo-white.png"),
                contentDescription = "Menu",
                modifier = Modifier
                    .size(48.dp) // adjust the size as needed
                    .clickable { /*TODO*/ }
            )
        },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Default.QrCodeScanner, contentDescription = "Qr")
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                IconButton(
                    onClick = {
                        navController.navigate("User")
                    }
                ) {
                    Icon(Icons.Rounded.Person, contentDescription = "user")
                }

            }
        }
    )
}










