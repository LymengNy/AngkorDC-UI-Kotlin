package com.example.finalproject.models



data class VideoModel(
    val VideoID: Int = 0,
    val videoUrl: String = ""
)

val videoList = listOf(
    VideoModel(
        VideoID = 1,
        videoUrl = "https://www.youtube.com/watch?v=UcXO4HTUYWo&pp=ygUP4Z6i4Z-K4Z-G4Z6F4Z6T" // Add YouTube video URL here
    ),
    VideoModel(
        VideoID = 2,
        videoUrl = "https://www.youtube.com/watch?v=UcXO4HTUYWo&pp=ygUP4Z6i4Z-K4Z-G4Z6F4Z6T" // Add YouTube video URL here
    ),
    // Add more videos with their respective YouTube video URLs
)
