package com.example.presentation.Screens.CommunityDetailScreen.useCases

import com.example.models.EventData
import com.example.presentation.Screens.CommunityDetailScreen.repo.CommunityEventsRepository

class GetUpcomingCommunityEventsUseCase(private val communityEventRepository: CommunityEventsRepository) {
    fun execute(): List<EventData> {
        return communityEventRepository.getUpcomingCommunityEvents()
    }
}
