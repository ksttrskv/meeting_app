package com.example.domain.model


data class Meeting(
    val title: String,
    val painter: String = "https://i.postimg.cc/GmsT4jPq/map-image.png",
    val date: String,
    val location: String,
    val isFinished: Boolean
)