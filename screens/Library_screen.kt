package com.example.finalproject.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.Image

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.example.finalproject.R


@Preview(showSystemUi = true)
@Composable
fun PreviewLibrary(){
    PurchPage(navController = rememberNavController())
}

@Composable
fun PurchPage(navController: NavController) {
    Column {
        composeTopNavBarLibrary(navController)
        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ) {
            item {
                Purch(navController)
            }
        }
    }
}



@Composable
fun DownlaodPage(navController: NavController) {
    Column {
        composeTopNavBarLibrary(navController)
        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ) {
            item {
                Downlaod(navController)
            }
        }
    }
}




@Composable
fun WatchPage(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black) // Set background color to black
    ) {
        Column {
            composeTopNavBarLibrary(navController)
            LazyColumn(
                modifier = Modifier.fillMaxWidth()
            ) {
                item {
                    watch(watchList)
                }
            }
        }
    }
}

@Composable
fun watch(watchList: List<String>) {
    Column(modifier = Modifier.fillMaxSize()) {
        val chunkedList = watchList.chunked(2)
        for (row in chunkedList) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                for (imageUrl in row) {
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .aspectRatio(1f)
                            .padding(4.dp) // Add padding for spacing
                            .clip(shape = RoundedCornerShape(8.dp)) // Rounded corners
                    ) {
                        Image(
                            painter = rememberImagePainter(
                                data = imageUrl,
                                builder = {
                                    // You can customize image loading here if needed
                                }
                            ),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                        Box(
                            modifier = Modifier
                                .size(50.dp)
                                .align(Alignment.Center)
                                .background(Color.Black, shape = CircleShape), // Background circle
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.PlayArrow,
                                contentDescription = "Play Now",
                                tint = Color.White,
                                modifier = Modifier.size(30.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}


val watchList = listOf<String>(
    "https://admin.angkordc.com/uploads/movie/1651113263-Private%20Love%20Website%20(New%20Movie%20Release).jpg",

    "https://admin.angkordc.com/uploads/movie/1626940032-coming%20soon.jpg",
    "https://admin.angkordc.com/uploads/movie/1658907457-coming%20soon%20900x700.jpg",
    "https://i.ytimg.com/vi/QYVfb2TFZiQ/hq720.jpg?sqp=-oaymwEhCK4FEIIDSFryq4qpAxMIARUAAAAAGAElAADIQj0AgKJD&rs=AOn4CLBK8WANvoxOXASz9Kdk5rjfT8xFWA",

)



@Composable
fun Purch(navController: NavController) {

}


@Composable
fun Downlaod(navController: NavController) {

}








@Composable
fun composeTopNavBarLibrary(navController: NavController) {
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

    val purchasedTextColor = if (currentRoute == "Library") Color.Yellow else Color.White
    val  watchPartyTextColor = if (currentRoute == "watch") Color.Yellow else Color.White
    val downloadedTextColor = if (currentRoute == "download") Color.Yellow else Color.White

    Box(
        modifier = Modifier
            .background(Color(0xFF000000)) // Background color for the navigation bar
            .height(50.dp)
    ) {
        Row(
            modifier = Modifier.padding(top = 10.dp).fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .background(Color(0xFF000000)) // Background color for the content of the navigation bar
                    .weight(1f) // Expand this box to fill the available space horizontally
            ) {
                Text(
                    "Purchased",
                    color = purchasedTextColor,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center, // Center align the text
                    modifier = Modifier.align(Alignment.Center)
                        .clickable { navController.navigate("Library") }
                )
            }
            Box(
                modifier = Modifier
                    .background(Color(0xFF000000)) // Background color for the content of the navigation bar
                    .weight(1f) // Expand this box to fill the available space horizontally
            ) {
                Text(
                    "Watch Party",
                    color = watchPartyTextColor,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center, // Center align the text
                    modifier = Modifier.align(Alignment.Center)
                        .clickable { navController.navigate("watch") }
                )
            }
            Box(
                modifier = Modifier
                    .background(Color(0xFF000000)) // Background color for the content of the navigation bar
                    .weight(1f) // Expand this box to fill the available space horizontally
            ) {
                Text(
                    "Downloaded",
                    color = downloadedTextColor,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center, // Center align the text
                    modifier = Modifier.align(Alignment.Center)
                        .clickable { navController.navigate("download") }
                )
            }
        }
    }
}

