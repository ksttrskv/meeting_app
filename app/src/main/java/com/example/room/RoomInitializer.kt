package com.example.room

import kotlinx.coroutines.flow.firstOrNull
import java.util.UUID

class RoomInitializer(private val eventDao: EventDao, private val communityDao: CommunityDao) {
    suspend fun initialize() {
        val eventsExist = eventDao.getAllEvents().firstOrNull()?.isNotEmpty() ?: false
        if (!eventsExist) {
            eventDao.insertEvents(
                listOf(
                    EventEntity(
                        eventId = UUID.randomUUID().toString(),
                        title = "Проджект-менеджмент: с чего начать?",
                        imageRes = "https://i.ytimg.com/vi/UE1Pkd7yOrg/maxresdefault.jpg",
                        date = "1 ноября",
                        location = "Ул. Марата, 10"
                    ),
                    EventEntity(
                        eventId = UUID.randomUUID().toString(),
                        title = "Разработка для начинающих: основы Python",
                        imageRes = "https://yamal-media.ru/images/insecure/rs:fill-down:1920:1080/aHR0cHM6Ly84NTQyMjAuc2VsY2RuLnJ1L3lhbWFsbmV3cy85NWE3OTk3Zi05MDYud2VicA.webp",
                        date = "3 ноября",
                        location = "Московский проспект, 56"
                    ),
                    EventEntity(
                        eventId = UUID.randomUUID().toString(),
                        title = "Как повышать грейд. Лекция Павла Хорикова",
                        imageRes = "https://lh3.googleusercontent.com/proxy/xErRF_3h-YgrklQQf7CSbwfzHDa43aexzr9JtquT6kzpEKgTDdLY39h0DAbBMtIqZ3HXC4JMT8lIeSVCXekPgi3vF4dpypL_9FjvQRitqtBe9VMSJr-cMibn2a8eTe7krOU",
                        date = "7 ноября",
                        location = "Невский проспект, 11"
                    ),
                    EventEntity(
                        eventId = UUID.randomUUID().toString(),
                        title = "Введение в DevOps",
                        imageRes = "https://web-academy.ua/blog/wp-content/uploads/2020/07/49.png",
                        date = "10 ноября",
                        location = "Ул. Пушкина, 47"
                    ),
                    EventEntity(
                        eventId = UUID.randomUUID().toString(),
                        title = "Путь в IT для школьников",
                        imageRes = "https://lh3.googleusercontent.com/proxy/xErRF_3h-YgrklQQf7CSbwfzHDa43aexzr9JtquT6kzpEKgTDdLY39h0DAbBMtIqZ3HXC4JMT8lIeSVCXekPgi3vF4dpypL_9FjvQRitqtBe9VMSJr-cMibn2a8eTe7krOU",
                        date = "15 ноября",
                        location = "наб. канала Грибоедова, 133"
                    )
                )
            )
        }
        val communitiesExist = communityDao.getAllCommunities().firstOrNull()?.isNotEmpty() ?: false
        if (!communitiesExist) {
            communityDao.insertCommunities(
                listOf(
                    CommunityEntity(
                        id = UUID.randomUUID().toString(),
                        title = "Wildberries",
                        imageUrl = "https://i.pinimg.com/736x/d4/ea/31/d4ea3162164c571e291e4cb49e74bdec.jpg"
                    ),
                    CommunityEntity(
                        id = UUID.randomUUID().toString(),
                        title = "The IT Crowd",
                        imageUrl = "https://www.cv-library.co.uk/career-advice/wp-content/uploads/2018/06/What-is-it-like-working-in-IT-e1651761435165.jpg"
                    ),
                    CommunityEntity(
                        id = UUID.randomUUID().toString(),
                        title = "Супер тестировщики",
                        imageUrl = "https://st4.depositphotos.com/16138592/27055/v/1600/depositphotos_270558146-stock-illustration-web-developer-avatar.jpg"
                    ),
                    CommunityEntity(
                        id = UUID.randomUUID().toString(),
                        title = "Developers Python",
                        imageUrl = "https://ares.by/uploaded/articles/116/116-1653398415-0-23.jpg"
                    ),
                    CommunityEntity(
                        id = UUID.randomUUID().toString(),
                        title = "True Design",
                        imageUrl = "https://legalacademy.ru/images/lfa/ARTICLE/5752648/COVER_LIST/5752660.jpg"
                    ),
                    CommunityEntity(
                        id = UUID.randomUUID().toString(),
                        title = "Мега ультра супер разработчики андроид",
                        imageUrl = "https://cdn-icons-png.flaticon.com/512/6840/6840478.png"
                    )
                )
            )
        }
    }
}

