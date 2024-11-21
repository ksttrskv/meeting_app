package com.example.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CommunityDao {
    @Query("SELECT * FROM communities")
    fun getAllCommunities(): Flow<List<CommunityEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCommunities(communities: List<CommunityEntity>)

    @Query("DELETE FROM communities")
    suspend fun clearCommunities()
}