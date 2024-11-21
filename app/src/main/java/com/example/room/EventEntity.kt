package com.example.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "events")
data class EventEntity(
    @PrimaryKey val eventId: String,
    val title: String,
    val date: String,
    val location: String,
    val imageRes: String? = null
)