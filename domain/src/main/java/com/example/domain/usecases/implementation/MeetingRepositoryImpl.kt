package com.example.domain.usecases.implementation

import MeetingRepository
import com.example.domain.model.Meeting
import com.example.domain.responses.GetMeetingsResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MeetingRepositoryImpl : MeetingRepository {
    override fun getMeetings(): List<Meeting> {
        return listOf(
            Meeting(title = "Developer meeting", location = "Москва", date = "15.10.2025", isFinished = true),
            Meeting(title = "Developer meeting", location = "Москва", date = "15.10.2025", isFinished = false),
            Meeting(title = "Developer meeting", location = "Москва", date = "15.10.2025", isFinished = false),
            Meeting(title = "Developer meeting", location = "Москва", date = "15.10.2025", isFinished = true),
            Meeting(title = "Developer meeting", location = "Москва", date = "15.10.2025", isFinished = false),
            Meeting(title = "Developer meeting", location = "Москва", date = "15.10.2025", isFinished = true),
            Meeting(title = "Developer meeting", location = "Москва", date = "15.10.2025", isFinished = false),
            Meeting(title = "Developer meeting", location = "Москва", date = "15.10.2025", isFinished = false),
            Meeting(title = "Developer meeting", location = "Москва", date = "15.10.2025", isFinished = true),
            )
    }
}