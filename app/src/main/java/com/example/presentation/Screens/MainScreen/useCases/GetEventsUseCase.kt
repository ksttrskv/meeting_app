package com.example.presentation.Screens.MainScreen.useCases

import com.example.models.EventData
import com.example.presentation.Screens.MainScreen.repo.EventsRepository
import kotlinx.coroutines.flow.Flow

//class GetEventsUseCase(private val eventsRepository: EventsRepository) {
//    suspend fun execute(): Flow<List<EventData>> {
//        return eventsRepository.getUpcomingEvents()
//    }
//}
class GetEventsUseCase(private val eventsRepository: EventsRepository) {
    fun execute(): Flow<List<EventData>> {
        return eventsRepository.getUpcomingEvents()
    }
}