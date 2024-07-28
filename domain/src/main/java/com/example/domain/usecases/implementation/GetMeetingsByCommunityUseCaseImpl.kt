package com.example.domain.usecases.implementation

import MeetingRepository
import com.example.domain.model.Meeting
import com.example.domain.usecases.interfaces.GetMeetingsByCommunityUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetMeetingsByCommunityUseCaseImpl(
    private val meetingRepository: MeetingRepository
) : GetMeetingsByCommunityUseCase {
    override fun execute(communityTitle: String): Flow<List<Meeting>> {
        return meetingRepository.getMeetingsByCommunity(communityTitle)
    }
}