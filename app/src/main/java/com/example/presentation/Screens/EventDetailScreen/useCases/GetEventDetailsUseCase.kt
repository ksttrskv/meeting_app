package com.example.presentation.Screens.EventDetailScreen.useCases

import com.example.models.EventDetailData
import com.example.presentation.Screens.EventDetailScreen.repo.EventDetailRepository

class GetEventDetailsUseCase(private val eventDetailRepository: EventDetailRepository) {
    fun execute(): EventDetailData {
        return eventDetailRepository.getEventDetail()
    }
}