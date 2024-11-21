package com.example.presentation.Screens.EventDetailScreen.useCases

import com.example.models.EventData
import com.example.presentation.Screens.CommunityDetailScreen.repo.CommunityEventsRepository

class GetCommunityEventsUseCase(private val communityEventRepository: CommunityEventsRepository) {
    fun execute(): List<EventData> {
        return communityEventRepository.getUpcomingCommunityEvents()
    }
}
