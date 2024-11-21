package com.example.presentation.Screens.OnboardingScreen.repo

interface TagsRepository {
    suspend fun getAllTags(): List<String>
}