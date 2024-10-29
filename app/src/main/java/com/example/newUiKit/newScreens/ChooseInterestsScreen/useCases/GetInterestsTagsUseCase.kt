package com.example.newUiKit.newScreens.ChooseInterestsScreen.useCases

import com.example.newUiKit.newScreens.OnboardingScreen.repo.TagsRepository

class GetInterestsTagsUseCase(private val tagsRepository: TagsRepository) {
    suspend fun execute(): List<String> {
        return tagsRepository.getAllTags()
    }
}