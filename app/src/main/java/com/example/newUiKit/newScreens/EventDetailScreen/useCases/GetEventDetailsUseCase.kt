package com.example.newUiKit.newScreens.EventDetailScreen.useCases

import com.example.models.EventDetailData
import com.example.newUiKit.newScreens.EventDetailScreen.repo.EventDetailRepository

class GetEventDetailsUseCase(private val eventDetailRepository: EventDetailRepository) {
    fun execute(): EventDetailData {
        return eventDetailRepository.getEventDetail()
    }
}