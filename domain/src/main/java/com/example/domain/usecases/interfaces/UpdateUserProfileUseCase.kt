package com.example.domain.usecases.interfaces

import com.example.domain.model.UserProfile
import com.example.domain.repository.ProfileRepository

class UpdateUserProfileUseCase(private val repository: ProfileRepository) {
    fun execute(userProfile: UserProfile) {
        return repository.updateUserProfile(userProfile)
    }
}