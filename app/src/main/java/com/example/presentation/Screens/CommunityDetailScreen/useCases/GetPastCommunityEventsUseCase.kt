package com.example.presentation.Screens.CommunityDetailScreen.useCases

import com.example.models.EventData
import com.example.presentation.Screens.CommunityDetailScreen.repo.CommunityEventsRepository

class GetPastCommunityEventsUseCase(private val communityEventRepository: CommunityEventsRepository) {
    fun execute(): List<EventData> {
        return communityEventRepository.getPastCommunityEvents()
    }
}