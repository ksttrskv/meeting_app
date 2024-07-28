package com.example.domain.repository

import com.example.domain.model.UserProfile
import kotlinx.coroutines.flow.Flow

interface ProfileRepository {
    fun getUserProfile(): Flow<UserProfile>
    fun saveUserProfile(userProfile: UserProfile): Flow<Boolean>
    fun updateUserProfile (userProfile: UserProfile)
}