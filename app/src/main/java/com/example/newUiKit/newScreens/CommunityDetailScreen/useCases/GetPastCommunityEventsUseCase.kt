package com.example.newUiKit.newScreens.CommunityDetailScreen.useCases

import com.example.models.EventData
import com.example.newUiKit.newScreens.CommunityDetailScreen.repo.CommunityEventsRepository

class GetPastCommunityEventsUseCase(private val communityEventRepository: CommunityEventsRepository) {
    fun execute(): List<EventData> {
        return communityEventRepository.getPastCommunityEvents()
    }
}