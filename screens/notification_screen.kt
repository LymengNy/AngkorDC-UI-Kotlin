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
import androidx.compose.material3.Button
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter


@Preview(showSystemUi = true)
@Composable
fun PreviewNotification(){
    ComingSoonPage(navController = rememberNavController())
}

@Composable
fun ComingSoonPage(navController: NavController) {
    Column {
        composeTopNavBarNotification(navController)
        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ) {
            item {
                ComingSoon()
            }
        }
    }
}


@Composable
fun NotificationPage(navController: NavController) {
    Column {
        composeTopNavBarNotification(navController)
        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ) {
            item {
                Notification()
            }
        }
    }
}



@Composable
fun composeTopNavBarNotification(navController: NavController) {
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

    val comingSoonTextColor = if (currentRoute == "coming_soon") Color.Yellow else Color.White
    val notificationTextColor = if (currentRoute == "notification") Color.Yellow else Color.White

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
                    .weight(1f) // Expand this box to fill the available space horizontally
            ) {
                Text(
                    "Coming Soon",
                    color = comingSoonTextColor,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center, // Center align the text
                    modifier = Modifier.align(Alignment.Center)
                        .clickable {
                            navController.navigate("coming_soon")
                        }
                )
            }
            Box(
                modifier = Modifier
                    .weight(1f) // Expand this box to fill the available space horizontally
            ) {
                Text(
                    "Notification",
                    color = notificationTextColor,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center, // Center align the text
                    modifier = Modifier.align(Alignment.Center)
                        .clickable {
                            navController.navigate("notification")
                        }
                )
            }
        }
    }
}


@Composable
fun LogoImage(
    imageUrl: String,
    modifier: Modifier = Modifier
) {
    // Load image using Coil or any other image loading library
    Image(
        painter = rememberImagePainter(imageUrl),
        contentDescription = null,
        modifier = modifier
    )
}








@Composable
fun ComingSoon() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        FoodList.forEachIndexed { index, imageUrl ->
            Box(
                modifier = Modifier
                    .size(width = 400.dp, height = 400.dp) // Adjust height as needed
            ) {
                Column {
                    // Image
                    AsyncImage(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth(),
                        model = imageUrl,
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )
                    // Text
                    TextList(index)
                }
            }
        }
    }
}

@Composable
fun Notification() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.Top
        ) {
            // Profile image
            Box(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
            )

            // NotiList
            NotiList()

            // Edit button
            // You can add an edit button here if needed
        }
    }
}

@Composable
fun NotiList() {
    Column(
        modifier = Modifier.padding(start = 16.dp) // Adding padding from the left
    ) {
        Spacer(modifier = Modifier.height(6.dp))
        // Displaying notification items
        TitleNoti.forEachIndexed { index, title ->
            NotificationItem(
                logoUrl = "https://www.angkordc.com/image/logo/logo-white.png",
                title = title,
                time = TimeList.getOrElse(index) { "" },
                description = DecsList.getOrElse(index) { "" }
            )
            Spacer(modifier = Modifier.height(8.dp)) // Add some vertical spacing between items
        }
    }
}

@Composable
fun NotificationItem(
    logoUrl: String,
    title: String,
    time: String,
    description: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Gray)
            .padding(16.dp)
    ) {
        // Display the logo
        LogoImage(
            imageUrl = logoUrl,
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
                .align(Alignment.CenterVertically)
        )

        // Add some horizontal space between the logo and text
        Spacer(modifier = Modifier.width(16.dp))

        // Display the text content
        Column {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color.White
            )
            Text(
                text = time,
                fontSize = 14.sp,
                color = Color.White
            )
            Text(
                text = description,
                fontSize = 14.sp,
                color = Color.White
            )
        }
    }
}



val TitleNoti = listOf(

    "នាឡិកាដាស់វិញ្ញាណមកដល់ហើយ...",
    "នាឡិកាដាស់វិញ្ញាណមកដល់ហើយ...",
    "នាឡិកាដាស់វិញ្ញាណមកដល់ហើយ...",
    "នាឡិកាដាស់វិញ្ញាណមកដល់ហើយ...",
    "នាឡិកាដាស់វិញ្ញាណមកដល់ហើយ...",
    "នាឡិកាដាស់វិញ្ញាណមកដល់ហើយ...",
    "នាឡិកាដាស់វិញ្ញាណមកដល់ហើយ...",
    "នាឡិកាដាស់វិញ្ញាណមកដល់ហើយ...",
    "នាឡិកាដាស់វិញ្ញាណមកដល់ហើយ...",
    "នាឡិកាដាស់វិញ្ញាណមកដល់ហើយ...",

)

val TimeList = listOf(

    "30 Apr 2024, 07:30 PM",
    "30 Apr 2024, 03:30 PM",
    "29 Apr 2024, 07:30 PM",
    "30 Apr 2024, 07:30 PM",
    "30 Apr 2024, 07:30 PM",
    "30 Apr 2024, 07:30 PM",
    "30 Apr 2024, 07:30 PM",
    "30 Apr 2024, 07:30 PM",
    "30 Apr 2024, 07:30 PM",
    "30 Apr 2024, 07:30 PM",
    "30 Apr 2024, 07:30 PM",

)

val DecsList = listOf(
    "រឿង << នាឡិកាដាស់វិញ្ញាណ || The clock : Spirit ...",
    "រឿង << នាឡិកាដាស់វិញ្ញាណ || The clock : Spirit ...",
    "រឿង << នាឡិកាដាស់វិញ្ញាណ || The clock : Spirit ...",
    "រឿង << នាឡិកាដាស់វិញ្ញាណ || The clock : Spirit ...",
    "រឿង << នាឡិកាដាស់វិញ្ញាណ || The clock : Spirit ...",
    "រឿង << នាឡិកាដាស់វិញ្ញាណ || The clock : Spirit ...",
    "រឿង << នាឡិកាដាស់វិញ្ញាណ || The clock : Spirit ...",
    "រឿង << នាឡិកាដាស់វិញ្ញាណ || The clock : Spirit ...",
    "រឿង << នាឡិកាដាស់វិញ្ញាណ || The clock : Spirit ...",
    "រឿង << នាឡិកាដាស់វិញ្ញាណ || The clock : Spirit ...",
)





@Composable
fun TextList(index: Int) {
    Box(
        modifier = Modifier
            .size(width = 400.dp, height = 120.dp)
            .background(Color.DarkGray)
    ) {
        Column(
            modifier = Modifier.padding(start = 16.dp) // Adding padding from the left
        ) {
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = ComingList[index], // Assuming ComingList is correct, otherwise replace it with the correct list
                color = Color.Yellow,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(10.dp)) // Adding spacer between Text elements
            Text(
                text = TittleList[index], // Assuming TittleList is correct, otherwise replace it with the correct list
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Text(
                text = TypeList[index], // Assuming TypeList is correct, otherwise replace it with the correct list
                color = Color.Gray,
                fontSize = 16.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )


        }
    }
}


val FoodList = listOf<String>(
    "https://admin.angkordc.com/uploads/movie/1651113263-Private%20Love%20Website%20(New%20Movie%20Release).jpg",
    "https://admin.angkordc.com/uploads/movie/1662083449-coming%20soon%20website%20900x700%20final.jpg",
    "https://admin.angkordc.com/uploads/movie/1626940032-coming%20soon.jpg",
    "https://admin.angkordc.com/uploads/movie/1658907457-coming%20soon%20900x700.jpg",
    "https://i.ytimg.com/vi/QYVfb2TFZiQ/hq720.jpg?sqp=-oaymwEhCK4FEIIDSFryq4qpAxMIARUAAAAAGAElAADIQj0AgKJD&rs=AOn4CLBK8WANvoxOXASz9Kdk5rjfT8xFWA",
    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQq3PNeBHFfIko3qCHvRuINBp_quipXpcm_ywfrs0KdDg&s",
    "https://admin.angkordc.com/uploads/movie/1642040322-Thort%20kun%20(Coming%20Soon)%20(1).jpg",
    "https://admin.angkordc.com/uploads/movie/1658907457-coming%20soon%20900x700.jpg"
    )
val ComingList = listOf(

    "Coming Mar 23",
    "Coming Feb 24",
    "Coming Feb 16",
    "Coming Jan 12",
    "Coming Dec 24",
    "Coming Dec 13",
    "Coming Nov 04",
    "Coming Apr 27",
)

val TittleList = listOf(

    "ស្នេហាPrivate",
    "Hello Neighbors",
    "លោកប្ដី",
    "លោកប៉ាមហារកូរ",
    "ជូបស៊យ​វគ្គ3",
    "បង្គោលគ្រាក់សង្កត់វិញ្ញាណ",
    "ថតគុន",
    "ក្រឡអីហ្នឹង វគ្គ3",
)

val TypeList = listOf(
    "COMEDY .HORROR",
    "COMEDY .ROMANCE",
    "COMEDY .ROMANCE",
    "COMEDY .ROMANCE",
    "COMEDY .ROMANCE",
    "COMEDY .HORROR",
    "COMEDY .HORROR",
    "COMEDY .ROMANCE"
)











