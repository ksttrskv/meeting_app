package com.example.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "communities")
data class CommunityEntity(
    @PrimaryKey val id: String, // Уникальный ID сообщества
    val title: String,
//    val description: String? = null,
    val imageUrl: String? = null
)