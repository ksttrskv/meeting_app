package com.example.domain.usecases.implementation

import com.example.domain.model.Meeting
import com.example.domain.responses.GetMeetingsResponse
import com.example.domain.usecases.interfaces.GetActiveMeetingsUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetActiveMeetingsUseCaseImpl : GetActiveMeetingsUseCase {

    override fun execute(): Flow<GetMeetingsResponse> {
        return flow {
            emit(
                GetMeetingsResponse(
                    data = mutableListOf<Meeting>().apply {
                        repeat(10) { index ->
                            add(
                                Meeting(
                                    title = "Developer meeting",
                                    painter = "https://i.postimg.cc/GmsT4jPq/map-image.png",
                                    date = "13.09.2024" ,
                                    location = "Москва",
                                    isFinished = false,
                                )
                            )
                        }
                    }
                )
            )
        }
    }
}