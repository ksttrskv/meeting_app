package com.example.presentation.Screens.CommunityDetailScreen.repo

import com.example.models.EventData

interface CommunityEventsRepository {
    fun getUpcomingCommunityEvents(): List<EventData>
    fun getPastCommunityEvents(): List<EventData>
}