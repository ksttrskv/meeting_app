package com.example.domain.usecases.interfaces

import com.example.domain.model.UserProfile
import com.example.domain.repository.ProfileRepository
import kotlinx.coroutines.flow.Flow

class GetUserProfileUseCase(private val repository: ProfileRepository) {
    fun execute(): Flow<UserProfile> {
        return repository.getUserProfile()
    }
}
