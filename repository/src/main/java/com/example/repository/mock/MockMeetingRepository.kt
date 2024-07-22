//package com.example.repository.mock
//
//import MeetingRepository
//import com.example.domain.model.Meeting
//import java.util.concurrent.Flow
//
//class MockMeetingRepository : MeetingRepository {
//    private val meetings = MutableStateFlow(
//         listOf(
//            Meeting("Developer meeting", "13.09.2024", "Москва", true),
//            Meeting("Another meeting", "15.10.2024", "Санкт-Петербург", false),
//            Meeting("Third meeting", "20.11.2024", "Новосибирск", false),
//            Meeting("Developer meeting", "13.09.2024", "Москва", true),
//            Meeting("Another meeting", "15.10.2024", "Санкт-Петербург", false),
//            Meeting("Third meeting", "20.11.2024", "Новосибирск", false),
//            Meeting("Developer meeting", "13.09.2024", "Москва", true),
//            Meeting("Another meeting", "15.10.2024", "Санкт-Петербург", false),
//            Meeting("Third meeting", "20.11.2024", "Новосибирск", false)
//        )
//    )
//
//    override fun getAllMeetings(): Flow<List<Meeting>> {
//        return meetings
//    }
//
//    override fun setMeetingStatus(title: String, isGoing: Boolean): Flow<Unit> {
//        val updatedMeetings = meetings.value.map {
//            if (it.title == title) it.copy(isGoing = isGoing) else it
//        }
//        meetings.value = updatedMeetings
//        return flowOf(Unit)
//    }
//}