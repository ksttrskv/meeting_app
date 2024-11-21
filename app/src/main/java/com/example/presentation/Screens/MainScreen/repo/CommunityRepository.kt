package com.example.presentation.Screens.MainScreen.repo

import com.example.models.CommunityData
import kotlinx.coroutines.flow.Flow

//interface CommunityRepository {
//    suspend fun getCommunities(): List<CommunityData>
//}
interface CommunityRepository {
    fun getCommunities(): Flow<List<CommunityData>>
    suspend fun insertCommunities(communities: List<CommunityData>)
}