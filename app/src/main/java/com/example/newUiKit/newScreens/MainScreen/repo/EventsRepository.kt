package com.example.newUiKit.newScreens.MainScreen.repo

import com.example.models.EventData

interface EventsRepository {
    suspend fun getUpcomingEvents(): List<EventData>
//    suspend fun getUpcomingCommunityEvents(): List<EventData>
//    suspend fun getUpcomingEvents(): List<EventData>
}