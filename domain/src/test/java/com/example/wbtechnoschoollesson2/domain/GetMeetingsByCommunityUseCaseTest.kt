package com.example.wbtechnoschoollesson2.domain

import com.example.domain.stubs.MeetingRepositoryStub
import com.example.domain.usecases.implementation.GetMeetingsByCommunityUseCaseImpl
import com.example.domain.usecases.interfaces.GetMeetingsByCommunityUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Before
import kotlin.test.Test
import kotlin.test.assertTrue

@ExperimentalCoroutinesApi
class GetMeetingsByCommunityUseCaseTest {

    private lateinit var getMeetingsByCommunityUseCase: GetMeetingsByCommunityUseCase

    @Before
    fun setUp() {
        // Использование заглушки репозитория для тестирования
        val meetingRepository = MeetingRepositoryStub()
        getMeetingsByCommunityUseCase = GetMeetingsByCommunityUseCaseImpl(meetingRepository)
    }

    @Test
    fun `execute should return a non-empty list of meetings`() = runTest {
        val meetings = getMeetingsByCommunityUseCase.execute("someCommunityTitle").first()
        assertTrue(meetings.isNotEmpty(), "Expected non-empty list of meetings")
    }

    @Test
    fun `each meeting should have a non-empty title`() = runTest {
        val meetings = getMeetingsByCommunityUseCase.execute("someCommunityTitle").first()
        meetings.forEach { meeting ->
            assertTrue(meeting.title.isNotEmpty(), "Expected meeting title to be non-empty")
        }
    }

    @Test
    fun `each meeting should have a non-empty location`() = runTest {
        val meetings = getMeetingsByCommunityUseCase.execute("someCommunityTitle").first()
        meetings.forEach { meeting ->
            assertTrue(meeting.location.isNotEmpty(), "Expected meeting location to be non-empty")
        }
    }

    @Test
    fun `each meeting should have a non-empty date`() = runTest {
        val meetings = getMeetingsByCommunityUseCase.execute("someCommunityTitle").first()
        meetings.forEach { meeting ->
            assertTrue(meeting.date.isNotEmpty(), "Expected meeting date to be non-empty")
        }
    }
}