package com.example.presentation.Screens.ChooseInterestsScreen.repo

import com.example.presentation.Screens.OnboardingScreen.repo.TagsRepository

class TagsInterestsRepositoryImpl : TagsRepository {
    override suspend fun getAllTags(): List<String> {
        return listOf(
            "Дизайн", "Разработка", "Продакт менеджмент", "Проджект менеджмент",
            "Backend", "Frontend", "Mobile", "Тестирование", "Продажи",
            "Бизнес", "Безопасность", "Web", "Девопс", "Маркетинг", "Аналитика"
        )
    }
}