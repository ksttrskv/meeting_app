package com.example.newUiKit.newScreens.EventDetailScreen.useCases

import com.example.models.EventData
import com.example.newUiKit.newScreens.CommunityDetailScreen.repo.CommunityEventsRepository

class GetCommunityEventsUseCase(private val communityEventRepository: CommunityEventsRepository) {
    fun execute(): List<EventData> {
        return communityEventRepository.getUpcomingCommunityEvents()
    }
}
