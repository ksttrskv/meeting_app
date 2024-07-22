package com.example.domain.usecases.interfaces

import com.example.domain.model.Community
import kotlinx.coroutines.flow.Flow

interface GetCommunityUseCase {
    fun execute(): Flow<List<Community>>
}