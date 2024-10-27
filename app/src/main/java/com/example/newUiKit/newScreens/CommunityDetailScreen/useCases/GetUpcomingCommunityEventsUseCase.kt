package com.example.newUiKit.newScreens.CommunityDetailScreen.useCases

import com.example.models.EventData
import com.example.newUiKit.newScreens.CommunityDetailScreen.repo.CommunityEventsRepository

class GetUpcomingCommunityEventsUseCase(private val communityEventRepository: CommunityEventsRepository) {
    fun execute(): List<EventData> {
        return communityEventRepository.getUpcomingCommunityEvents()
    }
}
