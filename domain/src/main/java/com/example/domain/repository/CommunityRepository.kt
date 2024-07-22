package com.example.domain.repository

import com.example.domain.model.Community

interface CommunityRepository {
    suspend fun getAllCommunities(): List<Community>
}