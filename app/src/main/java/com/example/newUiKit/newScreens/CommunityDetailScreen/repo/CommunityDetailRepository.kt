package com.example.newUiKit.newScreens.CommunityDetailScreen.repo

import com.example.models.CommunityDetailData
import com.example.models.UserData

interface CommunityDetailRepository {
    fun getCommunityDetails(): CommunityDetailData
    fun getCommunityMembers(): List<UserData>
}