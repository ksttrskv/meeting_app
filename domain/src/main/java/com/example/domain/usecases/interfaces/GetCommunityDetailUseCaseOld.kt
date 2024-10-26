package com.example.domain.usecases.interfaces

import com.example.domain.model.Community
import kotlinx.coroutines.flow.Flow

interface GetCommunityDetailUseCaseOld {
    fun execute(communityTitle: String): Flow<Community>
}