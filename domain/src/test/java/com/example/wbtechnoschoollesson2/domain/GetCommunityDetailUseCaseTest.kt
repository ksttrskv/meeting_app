package com.example.wbtechnoschoollesson2.domain

import com.example.domain.usecases.implementation.GetCommunityDetailUseCaseImpl
import com.example.domain.usecases.interfaces.GetCommunityDetailUseCase

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

@ExperimentalCoroutinesApi
class GetCommunityDetailUseCaseTest {

    private lateinit var getCommunityDetailUseCase: GetCommunityDetailUseCase

    @Before
    fun setUp() {
        // Replace with the real implementation when testing actual use cases
        getCommunityDetailUseCase = GetCommunityDetailUseCaseImpl()
    }

    @Test
    fun `execute should return a community`() = runTest {
        val community = getCommunityDetailUseCase.execute("someCommunityTitle").first()
        assertNotNull(community, "Expected a non-null community")
    }

    @Test
    fun `execute should return a community with valid data`() = runTest {
        val community = getCommunityDetailUseCase.execute("someCommunityTitle").first()
        assertTrue(community.title.isNotEmpty(), "Expected community title to be non-empty")
        assertTrue(community.subtitle.isNotEmpty(), "Expected community subtitle to be non-empty")
        assertTrue(community.imageUrl.isNotEmpty(), "Expected community imageUrl to be non-empty")
    }
}