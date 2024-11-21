package com.example.presentation.Screens.OnboardingScreen.useCases

import com.example.presentation.Screens.OnboardingScreen.repo.TagsRepository

class GetAllTagsUseCase(private val tagsRepository: TagsRepository) {
    suspend fun execute(): List<String> {
        return tagsRepository.getAllTags()
    }
}