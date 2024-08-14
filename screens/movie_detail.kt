package com.example.finalproject.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.Event
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.finalproject.models.MovieModel

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MovieDetailScreen(selectedMovie: MovieModel, navController: NavController) {
    Scaffold {
        Column(
            modifier = Modifier.fillMaxSize().background(Color.Black),
            verticalArrangement = Arrangement.Top
        ) {
            Box {
                Image(
                    painter = rememberImagePainter(selectedMovie.image),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(350.dp)
                )

                // Place the IconButton inside the Box composable
                IconButton(
                    onClick = { navController.popBackStack() },
                    modifier = Modifier.padding(16.dp)
                ) {
                    Icon(Icons.Default.Cancel, contentDescription = "Navigate Back")
                }

                // Overlaying play button on top of the image
                Box(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(50.dp)
                        .clip(CircleShape)
                        .background(Color.Black)
                        .padding(16.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.PlayArrow,
                        contentDescription = "Play Now",
                        tint = Color.White,
                        modifier = Modifier.size(50.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = selectedMovie.title,
                color = Color.White,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Text(
                text = selectedMovie.desc,
                color = Color.White,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Buttonpage()
            Text(
                text = "More",
                color = Color.White,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}



@Composable
fun Buttonpage() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 1.dp),
        verticalArrangement = Arrangement.spacedBy(1.dp)
    ) {
        Button(
            onClick = { /* Play now button clicked */ },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White
            ),
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                imageVector = Icons.Default.PlayArrow,
                contentDescription = "Play Now",
                tint = Color.Black
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text("Play Now", color = Color.Black) // Set text color to black
        }
        Button(
            onClick = { /* Watch Party button clicked */ },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Yellow
            ),
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                imageVector = Icons.Default.Event,
                contentDescription = "Watch Party",
                tint = Color.White
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text("Watch Party", color = Color.White) // Set text color to black
        }
        Button(
            onClick = { /* Download button clicked */ },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.DarkGray
            ),
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                imageVector = Icons.Default.Download,
                contentDescription = "Download",
                tint = Color.White
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text("Download", color = Color.White) // Set text color to black
        }
    }
}