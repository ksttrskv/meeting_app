package com.example.presentation.Screens.OnboardingScreen.repo

class TagsRepositoryImpl : TagsRepository {
    override suspend fun getAllTags(): List<String> {
        return listOf(
            "Дизайн", "Разработка", "Продакт менеджмент", "Проджект менеджмент",
            "Backend", "Frontend", "Mobile", "Тестирование", "Продажи",
            "Бизнес", "Безопасность", "Web", "Девопс", "Маркетинг", "Аналитика"
        )
    }
}