package com.example.presentation.Screens.MainScreen.repo

import com.example.models.EventData
import com.example.room.EventDao
import com.example.room.EventEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

//class EventsRepositoryImpl : EventsRepository {
//    override suspend fun getUpcomingEvents(): List<EventData> {
//        return listOf(
//            EventData(
//                eventId = UUID.randomUUID().toString(),
//                title = "Как повышать грейд. Лекция Павла Хорикова",
//                imageRes = "https://lh3.googleusercontent.com/proxy/xErRF_3h-YgrklQQf7CSbwfzHDa43aexzr9JtquT6kzpEKgTDdLY39h0DAbBMtIqZ3HXC4JMT8lIeSVCXekPgi3vF4dpypL_9FjvQRitqtBe9VMSJr-cMibn2a8eTe7krOU",
//                date = "15 октября",
//                location = "Лиговский проспект, 30",
//            ),
//            EventData(
//                eventId = UUID.randomUUID().toString(),
//                title = "Java Rush. Первые шаги",
//                imageRes = "https://i.ytimg.com/vi/UE1Pkd7yOrg/maxresdefault.jpg",
//                date = "20 октября",
//                location = "Невский проспект, 44"
//            ),
//            EventData(
//                eventId = UUID.randomUUID().toString(),
//                title = "Путь в IT для школьников",
//                imageRes = "https://yamal-media.ru/images/insecure/rs:fill-down:1920:1080/aHR0cHM6Ly84NTQyMjAuc2VsY2RuLnJ1L3lhbWFsbmV3cy85NWE3OTk3Zi05MDYud2VicA.webp",
//                date = "25 октября",
//                location = "наб. канала Грибоедова, 133"
//            ),
//            EventData(
//                eventId = UUID.randomUUID().toString(),
//                title = "День открытых дверей в IT-школе",
//                imageRes = "https://lh3.googleusercontent.com/proxy/xErRF_3h-YgrklQQf7CSbwfzHDa43aexzr9JtquT6kzpEKgTDdLY39h0DAbBMtIqZ3HXC4JMT8lIeSVCXekPgi3vF4dpypL_9FjvQRitqtBe9VMSJr-cMibn2a8eTe7krOU",
//                date = "30 октября",
//                location = "Проспект Бакунина, 21"
//            ),
//            EventData(
//                eventId = UUID.randomUUID().toString(),
//                title = "Проджект-менеджмент: с чего начать?",
//                imageRes = "https://web-academy.ua/blog/wp-content/uploads/2020/07/49.png",
//                date = "1 ноября",
//                location = "Ул. Марата, 10"
//            ),
//            EventData(
//                eventId = UUID.randomUUID().toString(),
//                title = "Разработка для начинающих: основы Python",
//                imageRes = "https://yamal-media.ru/images/insecure/rs:fill-down:1920:1080/aHR0cHM6Ly84NTQyMjAuc2VsY2RuLnJ1L3lhbWFsbmV3cy85NWE3OTk3Zi05MDYud2VicA.webp",
//                date = "3 ноября",
//                location = "Московский проспект, 56"
//            ),
//            EventData(
//                eventId = UUID.randomUUID().toString(),
//                title = "Как повышать грейд. Лекция Павла Хорикова",
//                imageRes = "https://lh3.googleusercontent.com/proxy/xErRF_3h-YgrklQQf7CSbwfzHDa43aexzr9JtquT6kzpEKgTDdLY39h0DAbBMtIqZ3HXC4JMT8lIeSVCXekPgi3vF4dpypL_9FjvQRitqtBe9VMSJr-cMibn2a8eTe7krOU",
//                date = "7 ноября",
//                location = "Невский проспект, 11"
//            ),
//            EventData(
//                eventId = UUID.randomUUID().toString(),
//                title = "Введение в DevOps",
//                imageRes = "https://web-academy.ua/blog/wp-content/uploads/2020/07/49.png",
//                date = "10 ноября",
//                location = "Ул. Пушкина, 47"
//            ),
//            EventData(
//                eventId = UUID.randomUUID().toString(),
//                title = "Путь в IT для школьников",
//                imageRes = "https://yamal-media.ru/images/insecure/rs:fill-down:1920:1080/aHR0cHM6Ly84NTQyMjAuc2VsY2RuLnJ1L3lhbWFsbmV3cy85NWE3OTk3Zi05MDYud2VicA.webp",
//                date = "15 ноября",
//                location = "наб. канала Грибоедова, 133"
//            )
//        )
//    }
//}
class EventsRepositoryImpl(private val eventDao: EventDao) : EventsRepository {
    override fun getUpcomingEvents(): Flow<List<EventData>> {
        return eventDao.getAllEvents().map { eventEntities ->
            eventEntities.map { entity ->
                EventData(
                    eventId = entity.eventId,
                    title = entity.title,
                    date = entity.date,
                    location = entity.location,
                    imageRes = entity.imageRes
                )
            }
        }
    }

    override suspend fun insertEvents(events: List<EventData>) {
        val eventEntities = events.map {
            EventEntity(
                eventId = it.eventId,
                title = it.title,
                date = it.date,
                location = it.location,
                imageRes = it.imageRes
            )
        }
        eventDao.insertEvents(eventEntities)
    }
}
