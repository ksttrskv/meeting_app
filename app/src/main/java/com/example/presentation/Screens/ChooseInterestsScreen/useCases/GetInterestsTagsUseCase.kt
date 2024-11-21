package com.example.presentation.Screens.ChooseInterestsScreen.useCases

import com.example.presentation.Screens.OnboardingScreen.repo.TagsRepository

class GetInterestsTagsUseCase(private val tagsRepository: TagsRepository) {
    suspend fun execute(): List<String> {
        return tagsRepository.getAllTags()
    }
}