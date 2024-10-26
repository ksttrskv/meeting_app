package com.example.newUiKit.newScreens.CommunityDetailScreen.useCases

import com.example.models.CommunityDetailData
import com.example.newUiKit.newScreens.CommunityDetailScreen.repo.CommunityRepository

class GetCommunityDetailsUseCase(private val communityRepository: CommunityRepository) {
    fun execute(): CommunityDetailData {
        return communityRepository.getCommunityDetails()
    }
}