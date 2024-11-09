package com.example.newUiKit.newScreens.CommunityDetailScreen.repo

import com.example.models.EventData
import java.util.UUID

class CommunityEventsRepositoryImpl : CommunityEventsRepository {
    override fun getUpcomingCommunityEvents(): List<EventData> {
        return listOf(
            EventData(
                title = "Проджект-менеджмент: с чего начать?",
                imageRes = "https://web-academy.ua/blog/wp-content/uploads/2020/07/49.png",
                date = "1 ноября",
                location = "Ул. Марата, 10",
                eventId = UUID.randomUUID().toString(),
            ),
            EventData(
                title = "Разработка для начинающих: основы Python",
                imageRes = "https://yamal-media.ru/images/insecure/rs:fill-down:1920:1080/aHR0cHM6Ly84NTQyMjAuc2VsY2RuLnJ1L3lhbWFsbmV3cy85NWE3OTk3Zi05MDYud2VicA.webp",
                date = "3 ноября",
                location = "Московский проспект, 56",
                eventId = UUID.randomUUID().toString(),
            ),
            EventData(
                title = "Как повышать грейд. Лекция Павла Хорикова",
                imageRes = "https://lh3.googleusercontent.com/proxy/xErRF_3h-YgrklQQf7CSbwfzHDa43aexzr9JtquT6kzpEKgTDdLY39h0DAbBMtIqZ3HXC4JMT8lIeSVCXekPgi3vF4dpypL_9FjvQRitqtBe9VMSJr-cMibn2a8eTe7krOU",
                date = "7 ноября",
                location = "Невский проспект, 11",
                eventId = UUID.randomUUID().toString(),
            ),
            EventData(
                title = "Введение в DevOps",
                imageRes = "https://web-academy.ua/blog/wp-content/uploads/2020/07/49.png",
                date = "10 ноября",
                location = "Ул. Пушкина, 47",
                eventId = UUID.randomUUID().toString(),
            ),
            EventData(
                title = "Путь в IT для школьников",
                imageRes = "https://yamal-media.ru/images/insecure/rs:fill-down:1920:1080/aHR0cHM6Ly84NTQyMjAuc2VsY2RuLnJ1L3lhbWFsbmV3cy85NWE3OTk3Zi05MDYud2VicA.webp",
                date = "15 ноября",
                location = "наб. канала Грибоедова, 133",
                eventId = UUID.randomUUID().toString(),
            )
        )
    }

    override fun getPastCommunityEvents(): List<EventData> {
        return listOf(
            EventData(
                title = "QA Talks — Global tech forum",
                imageRes = "https://www.cv-library.co.uk/career-advice/wp-content/uploads/2018/06/What-is-it-like-working-in-IT-e1651761435165.jpg",
                date = "Завтра",
                location = "Невский проспект, 11",
                eventId = UUID.randomUUID().toString(),
            ),
            EventData(
                title = "QA Talks — Global tech forum",
                imageRes = "https://aif-s3.aif.ru/images/031/407/9386b82829ced1e10f1d769aa4542e52.jpg",
                date = "Завтра",
                location = "Невский проспект, 11",
                eventId = UUID.randomUUID().toString(),
            ),
            EventData(
                title = "QA Talks — Global tech forum",
                imageRes = "https://aif-s3.aif.ru/images/031/407/9386b82829ced1e10f1d769aa4542e52.jpg",
                date = "Завтра",
                location = "Невский проспект, 11",
                eventId = UUID.randomUUID().toString(),
            )
        )
    }
}