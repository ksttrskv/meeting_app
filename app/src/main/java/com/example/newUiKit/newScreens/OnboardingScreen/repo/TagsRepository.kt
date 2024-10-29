package com.example.newUiKit.newScreens.OnboardingScreen.repo

interface TagsRepository {
    suspend fun getAllTags(): List<String>
}