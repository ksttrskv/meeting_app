package com.example.newUiKit.newScreens.MainScreen.repo

import com.example.models.CommunityData

class CommunityRepositoryImpl : CommunityRepository {
    override suspend fun getCommunities(): List<CommunityData> {
        return listOf(
            CommunityData(
                title = "хуйсосы]",
                imageRes = "https://www.cv-library.co.uk/career-advice/wp-content/uploads/2018/06/What-is-it-like-working-in-IT-e1651761435165.jpg"
            ),
            CommunityData(
                title = "The IT Crowd",
                imageRes = "https://www.cv-library.co.uk/career-advice/wp-content/uploads/2018/06/What-is-it-like-working-in-IT-e1651761435165.jpg"
            ),
            CommunityData(
                title = "Супер тестировщики",
                imageRes = "https://legalacademy.ru/images/lfa/ARTICLE/5752648/COVER_LIST/5752660.jpg"
            ),
            CommunityData(
                title = "Супер тестировщики",
                imageRes = "https://ares.by/uploaded/articles/116/116-1653398415-0-23.jpg"
            ),
            CommunityData(
                title = "Супер тестировщики",
                imageRes = "https://legalacademy.ru/images/lfa/ARTICLE/5752648/COVER_LIST/5752660.jpg"
            ),
            CommunityData(
                title = "Супер тестировщики",
                imageRes = "https://legalacademy.ru/images/lfa/ARTICLE/5752648/COVER_LIST/5752660.jpg"
            ),
        )
    }
}