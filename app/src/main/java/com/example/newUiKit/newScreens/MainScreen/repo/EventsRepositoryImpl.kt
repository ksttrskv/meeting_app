package com.example.newUiKit.newScreens.MainScreen.repo

import com.example.models.EventData

class EventsRepositoryImpl : EventsRepository {
    override suspend fun getUpcomingEvents(): List<EventData> {
        return listOf(
            EventData(
                title = "Как повышать грейд. Лекция Павла Хорикова",
                imageRes = "https://lh3.googleusercontent.com/proxy/xErRF_3h-YgrklQQf7CSbwfzHDa43aexzr9JtquT6kzpEKgTDdLY39h0DAbBMtIqZ3HXC4JMT8lIeSVCXekPgi3vF4dpypL_9FjvQRitqtBe9VMSJr-cMibn2a8eTe7krOU",
                date = "Завтра",
                location = "Невский проспект, 11"
            ),
            EventData(
                title = "педики",
                imageRes = "https://web-academy.ua/blog/wp-content/uploads/2020/07/49.png",
                date = "Завтра",
                location = "Невский проспект, 11"
            ),
            EventData(
                title = "Путь в IT для школьников",
                imageRes = "https://yamal-media.ru/images/insecure/rs:fill-down:1920:1080/aHR0cHM6Ly84NTQyMjAuc2VsY2RuLnJ1L3lhbWFsbmV3cy85NWE3OTk3Zi05MDYud2VicA.webp",
                date = "18 августа",
                location = "наб. канала Грибоедова, 133"
            ),
            EventData(
                title = "Как повышать грейд. Лекция Павла Хорикова",
                imageRes = "https://lh3.googleusercontent.com/proxy/xErRF_3h-YgrklQQf7CSbwfzHDa43aexzr9JtquT6kzpEKgTDdLY39h0DAbBMtIqZ3HXC4JMT8lIeSVCXekPgi3vF4dpypL_9FjvQRitqtBe9VMSJr-cMibn2a8eTe7krOU",
                date = "Завтра",
                location = "Невский проспект, 11"
            ),
            EventData(
                title = "педики",
                imageRes = "https://web-academy.ua/blog/wp-content/uploads/2020/07/49.png",
                date = "Завтра",
                location = "Невский проспект, 11"
            ),
            EventData(
                title = "Путь в IT для школьников",
                imageRes = "https://yamal-media.ru/images/insecure/rs:fill-down:1920:1080/aHR0cHM6Ly84NTQyMjAuc2VsY2RuLnJ1L3lhbWFsbmV3cy85NWE3OTk3Zi05MDYud2VicA.webp",
                date = "18 августа",
                location = "наб. канала Грибоедова, 133"
            ),
            EventData(
                title = "Как повышать грейд. Лекция Павла Хорикова",
                imageRes = "https://lh3.googleusercontent.com/proxy/xErRF_3h-YgrklQQf7CSbwfzHDa43aexzr9JtquT6kzpEKgTDdLY39h0DAbBMtIqZ3HXC4JMT8lIeSVCXekPgi3vF4dpypL_9FjvQRitqtBe9VMSJr-cMibn2a8eTe7krOU",
                date = "Завтра",
                location = "Невский проспект, 11"
            ),
            EventData(
                title = "педики",
                imageRes = "https://web-academy.ua/blog/wp-content/uploads/2020/07/49.png",
                date = "Завтра",
                location = "Невский проспект, 11"
            ),
            EventData(
                title = "Путь в IT для школьников",
                imageRes = "https://yamal-media.ru/images/insecure/rs:fill-down:1920:1080/aHR0cHM6Ly84NTQyMjAuc2VsY2RuLnJ1L3lhbWFsbmV3cy85NWE3OTk3Zi05MDYud2VicA.webp",
                date = "18 августа",
                location = "наб. канала Грибоедова, 133"
            )
        )
    }
}