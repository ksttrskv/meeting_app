package com.example.domain.usecases.interfaces

import com.example.domain.model.UserProfile
import com.example.domain.repository.ProfileRepository
import kotlinx.coroutines.flow.Flow

class SaveUserProfileUseCase(private val repository: ProfileRepository) {
    fun execute(userProfile: UserProfile): Flow<Boolean> {
        return repository.saveUserProfile(userProfile)
    }
}