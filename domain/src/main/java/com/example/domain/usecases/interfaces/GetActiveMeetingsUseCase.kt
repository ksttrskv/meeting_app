package com.example.domain.usecases.interfaces

import com.example.domain.responses.GetMeetingsResponse
import kotlinx.coroutines.flow.Flow

interface GetActiveMeetingsUseCase {
    fun execute(): Flow<GetMeetingsResponse>
}