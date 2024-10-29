package com.example.newUiKit.newScreens.OnboardingScreen.useCases

import com.example.newUiKit.newScreens.OnboardingScreen.repo.TagsRepository

class GetAllTagsUseCase(private val tagsRepository: TagsRepository) {
    suspend fun execute(): List<String> {
        return tagsRepository.getAllTags()
    }
}