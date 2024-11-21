package com.example.presentation.Screens.MainScreen.repo

import com.example.models.EventData
import kotlinx.coroutines.flow.Flow

//interface EventsRepository {
//    suspend fun getUpcomingEvents(): List<EventData>
//}

interface EventsRepository {
    fun getUpcomingEvents(): Flow<List<EventData>>
    suspend fun insertEvents(events: List<EventData>)
}