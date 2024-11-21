package com.example.presentation.Screens.EventDetailScreen.repo

import com.example.models.EventData
import com.example.models.EventDetailData
import com.example.models.UserData

interface EventDetailRepository {
    fun getEventDetail(): EventDetailData
    fun getEventMembers(): List<UserData>
    fun getCommunityEvents(): List<EventData>
}