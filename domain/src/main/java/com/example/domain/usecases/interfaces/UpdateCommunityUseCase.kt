package com.example.domain.usecases.interfaces

import com.example.domain.model.Community
import kotlinx.coroutines.flow.Flow

interface UpdateCommunityUseCase {
    fun execute(community: Community): Flow<Boolean>
}