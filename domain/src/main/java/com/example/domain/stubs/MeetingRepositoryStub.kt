package com.example.domain.stubs

import MeetingRepository
import com.example.domain.model.Meeting
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MeetingRepositoryStub : MeetingRepository {
    override fun getMeetings(): List<Meeting> {
        return listOf(
            Meeting(title = "Developer meeting", location = "Москва", date = "15.10.2025", isFinished = true),
            Meeting(title = "Developer meeting", location = "Москва", date = "15.10.2025", isFinished = false),
            Meeting(title = "Developer meeting", location = "Москва", date = "15.10.2025", isFinished = false),
            Meeting(
                title = "Developer meeting",
                location = "Москва",
                date = "15.10.2025",
                isFinished = true
            ),
            Meeting(
                title = "Developer meeting",
                location = "Москва",
                date = "15.10.2025",
                isFinished = false
            ),
            Meeting(
                title = "Developer meeting",
                location = "Москва",
                date = "15.10.2025",
                isFinished = false
            ),
            Meeting(title = "Developer meeting", location = "Москва", date = "15.10.2025", isFinished = true)
        )
    }

    override fun getMeetingsByCommunity(communityTitle: String): Flow<List<Meeting>> {
        return flow {
            emit(
                listOf(
                    Meeting(title = "Developer meeting", location = "Москва", date = "15.10.2025", isFinished = true),
                    Meeting(title = "Developer meeting", location = "Москва", date = "15.10.2025", isFinished = false),
                    Meeting(title = "Developer meeting", location = "Москва", date = "15.10.2025", isFinished = false),
                    Meeting(
                        title = "Developer meeting",
                        location = "Москва",
                        date = "15.10.2025",
                        isFinished = true
                    ),
                    Meeting(
                        title = "Developer meeting",
                        location = "Москва",
                        date = "15.10.2025",
                        isFinished = false
                    ),
                    Meeting(
                        title = "Developer meeting",
                        location = "Москва",
                        date = "15.10.2025",
                        isFinished = false
                    ),
                    Meeting(title = "Developer meeting", location = "Москва", date = "15.10.2025", isFinished = true)
                )
            )
        }
    }
}