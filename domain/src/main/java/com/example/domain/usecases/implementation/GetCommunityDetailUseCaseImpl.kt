package com.example.domain.usecases.implementation

import com.example.domain.model.Community
import com.example.domain.usecases.interfaces.GetCommunityDetailUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetCommunityDetailUseCaseImpl : GetCommunityDetailUseCase {
    override fun execute(communityTitle: String): Flow<Community> {
        return flow {
            emit(Community("https://i.postimg.cc/GmsT4jPq/map-image.png", communityTitle, "10 000 человек"))
        }
    }
}