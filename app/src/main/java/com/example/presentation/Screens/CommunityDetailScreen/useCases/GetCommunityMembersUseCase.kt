package com.example.presentation.Screens.CommunityDetailScreen.useCases

import com.example.models.UserData
import com.example.presentation.Screens.CommunityDetailScreen.repo.CommunityDetailRepository

class GetCommunityMembersUseCase(private val communityDetailRepository: CommunityDetailRepository) {
    fun execute(): List<UserData> {
        return communityDetailRepository.getCommunityMembers()
    }
}