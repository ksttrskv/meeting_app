package com.example.repository.repositories

//import MeetingRepository
//import com.example.domain.model.Meeting
//import java.util.concurrent.Flow
//
//class MeetingRepositoryImpl : MeetingRepository {
//
//    private val meetings = MutableStateFlow<List<Meeting>>(emptyList())
//
//    override fun getAllMeetings(): Flow<List<Meeting>> {
//        return meetings
//    }
//
//    override fun getActiveMeetings(): Flow<List<Meeting>> {
//        return meetings.map { it.filter { meeting -> !meeting.isFinished } }
//    }
//
//    override suspend fun addMeeting(meeting: Meeting) {
//        TODO("Not yet implemented")
//    }
//
//    override suspend fun updateMeeting(meeting: Meeting) {
//        TODO("Not yet implemented")
//    }
//
//    override suspend fun deleteMeeting(meeting: Meeting) {
//        TODO("Not yet implemented")
//    }
//}