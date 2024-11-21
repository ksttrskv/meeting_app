package com.example.presentation.Screens.EventDetailScreen.useCases

import com.example.models.UserData
import com.example.presentation.Screens.EventDetailScreen.repo.EventDetailRepository

class GetEventMembersUseCase(private val eventDetailRepository: EventDetailRepository) {
    fun execute(): List<UserData> {
        return eventDetailRepository.getEventMembers()
    }
}