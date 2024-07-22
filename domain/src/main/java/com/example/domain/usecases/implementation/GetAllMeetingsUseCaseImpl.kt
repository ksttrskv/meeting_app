package com.example.domain.usecases.implementation

import com.example.domain.model.Meeting
import com.example.domain.responses.GetMeetingsResponse
import com.example.domain.usecases.interfaces.GetAllMeetingsUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetAllMeetingsUseCaseImpl : GetAllMeetingsUseCase {

    override fun execute(): Flow<GetMeetingsResponse> {
        return flow {
            emit(
                GetMeetingsResponse(
                    data = mutableListOf<Meeting>().apply {
                        repeat(10) { index ->
                            add(
                                Meeting(
                                    title = "Developer meeting",
                                    painter = "",
                                    date = "13.09.2024" ,
                                    location = "Москва",
                                    isFinished = true,
                                )
                            )
                        }
                    }
                )
            )
        }
    }
}