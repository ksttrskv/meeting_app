package com.example.wbtechnoschoollesson2.domain

import com.example.domain.stubs.CommunityStub
import com.example.domain.usecases.interfaces.GetCommunityUseCase
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class GetCommunityUseCaseTest {

    private lateinit var getCommunityUseCase: GetCommunityUseCase

    @Before
    fun setUp() {
        // Replace with the real implementation when testing actual use cases
        getCommunityUseCase = CommunityStub()
    }

    @Test
    fun `execute should return a non-empty list of communities`() = runTest {
        val communities = getCommunityUseCase.execute().first()
        assertTrue("Expected non-empty list of communities", communities.isNotEmpty())
    }

    @Test
    fun `execute should return a list of communities with valid data`() = runTest {
        val communities = getCommunityUseCase.execute().first()
        communities.forEach { community ->
            assertTrue("Expected community title to be non-empty", community.title.isNotEmpty())
            assertTrue("Expected community subtitle to be non-empty", community.subtitle.isNotEmpty())
            assertTrue("Expected community imageUrl to be non-empty", community.imageUrl.isNotEmpty())
        }
    }
}