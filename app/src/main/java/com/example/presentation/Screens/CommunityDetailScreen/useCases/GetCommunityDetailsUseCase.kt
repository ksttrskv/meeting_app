package com.example.presentation.Screens.CommunityDetailScreen.useCases

import com.example.models.CommunityDetailData
import com.example.presentation.Screens.CommunityDetailScreen.repo.CommunityDetailRepository

class GetCommunityDetailsUseCase(private val communityDetailRepository: CommunityDetailRepository) {
    fun execute(): CommunityDetailData {
        return communityDetailRepository.getCommunityDetails()
    }
}