package com.example.finalproject.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextField
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.Icon
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.material3.Button
import androidx.compose.ui.Alignment
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.ui.text.font.FontWeight

import com.example.finalproject.models.movieList

@Composable
fun Userpage(navController: NavController) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .background(Color.Black)
                // Adjust padding for bottom bar
        ) {
           First()
        second()// ass the NavController here
            Spacer(modifier = Modifier.height(20.dp))
            third()
            Spacer(modifier = Modifier.height(20.dp))
            Four()
        }
    }



@Composable
fun ProfileImage(
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
fun First(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Profile image
            ProfileImage(
                imageUrl = "https://static.scientificamerican.com/sciam/cache/file/2AE14CDD-1265-470C-9B15F49024186C10_source.jpg?w=600",
                modifier = Modifier
                    .size(100.dp)
                    .padding(end = 16.dp)
                    .clip(CircleShape)
            )
            

            // Text and Edit button
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "Ny Lymeng",
                    color = Color.White,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                Button(
                    onClick = { /* Handle edit button click */ },
                    modifier = Modifier.align(Alignment.Start),


                ) {
                    Text(text = "Edit")
                }
            }
        }
    }
}

@Composable
fun second() {
    Column {
        Text(
            text = "Rewards",
            fontSize = 24.sp,
            color = Color.Gray,
            modifier = Modifier.padding(start = 8.dp, top = 8.dp)
        )
        Divider(color = Color.Gray, thickness = 2.dp)
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Referral Points",
            fontSize = 20.sp,
            color = Color.White,
            modifier = Modifier.padding(start = 8.dp, top = 8.dp),

        )
    }
}

@Composable
fun third() {
    Column {
        Text(
            text = "Referral Code",
            fontSize = 24.sp,
            color = Color.Gray,
            modifier = Modifier.padding(start = 8.dp, top = 8.dp),
            fontWeight = FontWeight.Bold
        )
        Divider(color = Color.Gray, thickness = 2.dp)
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth() // Expand the Row to fill the width
        ) {
            // Icon at the left side
            Text(
                text = "Share My Code",
                fontSize = 20.sp,
                color = Color.White,
                modifier = Modifier.padding(start = 8.dp, top = 8.dp)
            )
            Spacer(modifier = Modifier.width(8.dp)) // Add spacing between icon and text
            // Text at the right side
            Icon(
                imageVector = Icons.Default.ArrowForwardIos,
                contentDescription = "Share Icon",
                tint = Color.White,
                modifier = Modifier.size(20.dp)
            )
        }
    }
}


@Composable
fun Four() {
    Column {
        Text(
            text = "Imformations",
            fontSize = 24.sp,
            color = Color.Gray,
            modifier = Modifier.padding(start = 8.dp, top = 8.dp),
            fontWeight = FontWeight.Bold
        )
        Divider(color = Color.Gray, thickness = 2.dp)
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth() // Expand the Row to fill the width
        ) {
            // Text at the left side
            Text(
                text = "Abouts Us",
                fontSize = 20.sp,
                color = Color.White,
                modifier = Modifier.padding(start = 8.dp, top = 8.dp)
            )
            Spacer(modifier = Modifier.weight(1f)) // Add flexible space between text and icon
            // Icon at the right side
            Icon(
                imageVector = Icons.Default.ArrowForwardIos,
                contentDescription = "Share Icon",
                tint = Color.White,
                modifier = Modifier.size(20.dp)
            )
        }
        Spacer(modifier = Modifier.height(10.dp)) // Add space between the two rows
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth() // Expand the Row to fill the width
        ) {
            // Text at the left side
            Text(
                text = "Terms and Conditions",
                fontSize = 20.sp,
                color = Color.White,
                modifier = Modifier.padding(start = 8.dp, top = 8.dp)
            )
            Spacer(modifier = Modifier.weight(1f)) // Add flexible space between text and icon
            // Icon at the right side
            Icon(
                imageVector = Icons.Default.ArrowForwardIos,
                contentDescription = "Share Icon",
                tint = Color.White,
                modifier = Modifier.size(20.dp)
            )
        }
    }
}



