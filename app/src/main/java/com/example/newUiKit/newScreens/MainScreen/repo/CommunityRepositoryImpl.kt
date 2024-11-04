package com.example.newUiKit.newScreens.MainScreen.repo

import com.example.models.CommunityData

class CommunityRepositoryImpl : CommunityRepository {
    override suspend fun getCommunities(): List<CommunityData> {
        return listOf(
            CommunityData(
                title = "Wildberries",
                imageRes = "https://i.pinimg.com/736x/d4/ea/31/d4ea3162164c571e291e4cb49e74bdec.jpg"
            ),
            CommunityData(
                title = "The IT Crowd",
                imageRes = "https://www.cv-library.co.uk/career-advice/wp-content/uploads/2018/06/What-is-it-like-working-in-IT-e1651761435165.jpg"
            ),
            CommunityData(
                title = "Супер тестировщики",
                imageRes = "https://st4.depositphotos.com/16138592/27055/v/1600/depositphotos_270558146-stock-illustration-web-developer-avatar.jpg"
            ),
            CommunityData(
                title = "Developers Python",
                imageRes = "https://ares.by/uploaded/articles/116/116-1653398415-0-23.jpg"
            ),
            CommunityData(
                title = "True Design",
                imageRes = "https://legalacademy.ru/images/lfa/ARTICLE/5752648/COVER_LIST/5752660.jpg"
            ),
            CommunityData(
                title = "Мега ультра супер разработчики андроид",
                imageRes = "https://cdn-icons-png.flaticon.com/512/6840/6840478.png"
            ),
        )
    }
}