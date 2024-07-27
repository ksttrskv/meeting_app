package com.example.domain.stubs

import com.example.domain.model.UserProfile
import com.example.domain.repository.ProfileRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow

class ProfileRepositoryStub : ProfileRepository {

    private var userProfile = UserProfile("Иван", "Иванов")

    override fun getUserProfile(): Flow<UserProfile> {
        return flow {
            emit(userProfile)
        }
    }

    override fun saveUserProfile(userProfile: UserProfile): Flow<Boolean> {
        return flow {
            this@ProfileRepositoryStub.userProfile = userProfile
            emit(true)
        }
    }
    override fun updateUserProfile(userProfile: UserProfile) {
        this.userProfile = userProfile
    }
}
