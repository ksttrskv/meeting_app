package com.example.newUiKit.newScreens.CommunityDetailScreen.repo

import com.example.models.EventData

class CommunityEventsRepositoryImpl : CommunityEventsRepository {
    override fun getUpcomingCommunityEvents(): List<EventData> {
        return listOf(
            EventData(
                title = "Как пресс качат. Лекция Павла Дурова",
                imageRes = "https://lh3.googleusercontent.com/proxy/xErRF_3h-YgrklQQf7CSbwfzHDa43aexzr9JtquT6kzpEKgTDdLY39h0DAbBMtIqZ3HXC4JMT8lIeSVCXekPgi3vF4dpypL_9FjvQRitqtBe9VMSJr-cMibn2a8eTe7krOU",
                date = "Завтра",
                location = "Невский проспект, 11"
            ),
            EventData(
                title = "Попойка века",
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
                title = "Как пресс качат. Лекция Павла Дурова",
                imageRes = "https://lh3.googleusercontent.com/proxy/xErRF_3h-YgrklQQf7CSbwfzHDa43aexzr9JtquT6kzpEKgTDdLY39h0DAbBMtIqZ3HXC4JMT8lIeSVCXekPgi3vF4dpypL_9FjvQRitqtBe9VMSJr-cMibn2a8eTe7krOU",
                date = "Завтра",
                location = "Невский проспект, 11"
            ),
            EventData(
                title = "Попойка века",
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

    override fun getPastCommunityEvents(): List<EventData> {
        return listOf(
            EventData(
                title = "QA Talks — Global tech forum",
                imageRes = "https://www.cv-library.co.uk/career-advice/wp-content/uploads/2018/06/What-is-it-like-working-in-IT-e1651761435165.jpg",
                date = "Завтра",
                location = "Невский проспект, 11",
            ),
            EventData(
                title = "QA Talks — Global tech forum",
                imageRes = "https://aif-s3.aif.ru/images/031/407/9386b82829ced1e10f1d769aa4542e52.jpg",
                date = "Завтра",
                location = "Невский проспект, 11",
            ),
            EventData(
                title = "QA Talks — Global tech forum",
                imageRes = "https://aif-s3.aif.ru/images/031/407/9386b82829ced1e10f1d769aa4542e52.jpg",
                date = "Завтра",
                location = "Невский проспект, 11",
            )
        )
    }
}