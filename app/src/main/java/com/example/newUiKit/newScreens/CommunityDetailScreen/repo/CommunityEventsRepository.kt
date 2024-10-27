package com.example.newUiKit.newScreens.CommunityDetailScreen.repo

import com.example.models.EventData

interface CommunityEventsRepository {
    fun getUpcomingCommunityEvents(): List<EventData>
    fun getPastCommunityEvents(): List<EventData>
}