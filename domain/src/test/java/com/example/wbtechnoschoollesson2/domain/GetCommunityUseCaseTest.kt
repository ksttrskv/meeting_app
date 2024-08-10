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
        // Подмена реальной реализации для тестирования
        getCommunityUseCase = CommunityStub()
    }

    @Test
    fun `execute should return a non-empty list of communities`() = runTest {
        val communities = getCommunityUseCase.execute().first()
        assertTrue("Expected non-empty list of communities", communities.isNotEmpty())
    }

    @Test
    fun `each community should have a non-empty title`() = runTest {
        val communities = getCommunityUseCase.execute().first()
        communities.forEach { community ->
            assertTrue("Expected community title to be non-empty", community.title.isNotEmpty())
        }
    }

    @Test
    fun `each community should have a non-empty subtitle`() = runTest {
        val communities = getCommunityUseCase.execute().first()
        communities.forEach { community ->
            assertTrue("Expected community subtitle to be non-empty", community.subtitle.isNotEmpty())
        }
    }

    @Test
    fun `each community should have a non-empty imageUrl`() = runTest {
        val communities = getCommunityUseCase.execute().first()
        communities.forEach { community ->
            assertTrue("Expected community imageUrl to be non-empty", community.imageUrl.isNotEmpty())
        }
    }
}