package com.example.newUiKit.newScreens.CommunityDetailScreen.useCases

import com.example.models.UserData
import com.example.newUiKit.newScreens.CommunityDetailScreen.repo.CommunityRepository

class GetCommunityMembersUseCase(private val communityRepository: CommunityRepository) {
    fun execute(): List<UserData> {
        return communityRepository.getCommunityMembers()
    }
}