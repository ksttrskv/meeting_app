package com.example.newUiKit.newScreens.EventDetailScreen.useCases

import com.example.models.UserData
import com.example.newUiKit.newScreens.EventDetailScreen.repo.EventDetailRepository

class GetEventMembersUseCase(private val eventDetailRepository: EventDetailRepository) {
    fun execute(): List<UserData> {
        return eventDetailRepository.getEventMembers()
    }
}