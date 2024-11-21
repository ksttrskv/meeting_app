package com.example.models

data class EventData(
    val eventId: String,
    val title: String,
    val imageRes: String? = "",
    val date: String,
    val location: String
)