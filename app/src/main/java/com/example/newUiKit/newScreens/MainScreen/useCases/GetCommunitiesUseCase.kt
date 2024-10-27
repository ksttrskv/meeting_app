package com.example.newUiKit.newScreens.MainScreen.useCases

import com.example.models.CommunityData
import com.example.newUiKit.newScreens.MainScreen.repo.CommunityRepository

class GetCommunitiesUseCase(private val communityRepository: CommunityRepository) {
    suspend fun execute(): List<CommunityData> {
        return communityRepository.getCommunities()
    }
}