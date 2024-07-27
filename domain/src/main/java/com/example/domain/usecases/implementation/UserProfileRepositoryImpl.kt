package com.example.domain.usecases.implementation

import com.example.domain.model.UserProfile
import com.example.domain.repository.ProfileRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

//class UserProfileRepositoryImpl : ProfileRepository {
//
//    private var userProfile: UserProfile? = null
//
//    override fun getUserProfile(): Flow<UserProfile> = flow {
//        userProfile?.let { emit(it) } ?: emit(UserProfile("", ""))
//    }
//
//    override fun saveUserProfile(userProfile: UserProfile) {
//        this.userProfile = userProfile
//    }
//}