package com.example.presentation.Screens.CommunityDetailScreen.repo

import com.example.models.CommunityDetailData
import com.example.models.UserData

interface CommunityDetailRepository {
    fun getCommunityDetails(): CommunityDetailData
    fun getCommunityMembers(): List<UserData>
}