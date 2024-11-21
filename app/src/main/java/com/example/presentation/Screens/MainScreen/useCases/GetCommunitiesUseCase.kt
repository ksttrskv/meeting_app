package com.example.presentation.Screens.MainScreen.useCases

import com.example.models.CommunityData
import com.example.presentation.Screens.MainScreen.repo.CommunityRepository
import kotlinx.coroutines.flow.Flow

//class GetCommunitiesUseCase(private val communityRepository: CommunityRepository) {
//    suspend fun execute(): List<CommunityData> {
//        return communityRepository.getCommunities()
//    }
//}
class GetCommunitiesUseCase(private val communityRepository: CommunityRepository) {
    fun execute(): Flow<List<CommunityData>> {
        return communityRepository.getCommunities()
    }
}