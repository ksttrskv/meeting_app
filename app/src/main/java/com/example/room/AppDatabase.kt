package com.example.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [EventEntity::class, CommunityEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun eventDao(): EventDao
    abstract fun communityDao(): CommunityDao
}