package com.example.domain.usecases.interfaces

import com.example.domain.model.Meeting
import kotlinx.coroutines.flow.Flow

interface GetMeetingsByCommunityUseCase {
    fun execute(communityTitle: String): Flow<List<Meeting>>
}