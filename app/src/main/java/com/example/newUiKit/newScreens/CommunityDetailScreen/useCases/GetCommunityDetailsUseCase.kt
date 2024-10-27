package com.example.newUiKit.newScreens.CommunityDetailScreen.useCases

import com.example.models.CommunityDetailData
import com.example.newUiKit.newScreens.CommunityDetailScreen.repo.CommunityDetailRepository

class GetCommunityDetailsUseCase(private val communityDetailRepository: CommunityDetailRepository) {
    fun execute(): CommunityDetailData {
        return communityDetailRepository.getCommunityDetails()
    }
}