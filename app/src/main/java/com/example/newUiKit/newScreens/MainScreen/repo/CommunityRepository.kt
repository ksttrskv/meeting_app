package com.example.newUiKit.newScreens.MainScreen.repo

import com.example.models.CommunityData

interface CommunityRepository {
    suspend fun getCommunities(): List<CommunityData>
}