package com.example.newUiKit.newScreens.CommunityDetailScreen.useCases

import com.example.models.UserData
import com.example.newUiKit.newScreens.CommunityDetailScreen.repo.CommunityDetailRepository

class GetCommunityMembersUseCase(private val communityDetailRepository: CommunityDetailRepository) {
    fun execute(): List<UserData> {
        return communityDetailRepository.getCommunityMembers()
    }
}