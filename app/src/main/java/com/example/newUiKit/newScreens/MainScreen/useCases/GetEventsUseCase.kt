package com.example.newUiKit.newScreens.MainScreen.useCases

import com.example.models.EventData
import com.example.newUiKit.newScreens.MainScreen.repo.EventsRepository

class GetEventsUseCase(private val eventsRepository: EventsRepository) {
    suspend fun execute(): List<EventData> {
        return eventsRepository.getUpcomingEvents()
    }
}