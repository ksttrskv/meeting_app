package com.example.newUiKit.newScreens.MainScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.newUiKit.NewMolecules.EventCardThin

@Composable
fun EventCardThinLine() {
    LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
        item {
            EventCardThin(
                title = "Python days",
                imageUrl = "https://vmind.ru/wp-content/uploads/2013/11/37670_it-party.jpg",
                date = "10 августа",
                location = "Кожевенная линия, 40",
                onClick = {},
                modifier = Modifier.padding(start = 16.dp)
            )
        }
        item {
            EventCardThin(
                title = "Турнир разработчиков «Белые ночи»",
                imageUrl = "https://vmind.ru/wp-content/uploads/2013/11/37670_it-party.jpg",
                date = "10 августа",
                location = "Кожевенная линия, 40",
                onClick = {})
        }
        item {
            EventCardThin(
                title = "Python days",
                imageUrl = "https://vmind.ru/wp-content/uploads/2013/11/37670_it-party.jpg",
                date = "10 августа",
                location = "Кожевенная линия, 40",
                onClick = {})
        }
        item {
            EventCardThin(
                title = "Турнир разработчиков «Белые ночи»",
                imageUrl = "https://media.licdn.com/dms/image/D4E12AQHt2wyq9skOLQ/article-cover_image-shrink_720_1280/0/1679312115058?e=2147483647&v=beta&t=QfVmISyB-ui1f39VDdBVNGbkXyyr5aDyuoNNa0OdAao",
                date = "10 августа",
                location = "Кожевенная линия, 40",
                onClick = {})
        }
        item {
            EventCardThin(
                title = "Python days",
                imageUrl = "https://cached.imagescaler.hbpl.co.uk/resize/scaleWidth/1272/cached.offlinehbpl.hbpl.co.uk/news/OMP/GettyImages-1217856040-.jpg",
                date = "10 августа",
                location = "Кожевенная линия, 40",
                onClick = {})
        }
        item {
            EventCardThin(
                title = "Турнир разработчиков «Белые ночи»",
                imageUrl = "https://www.cv-library.co.uk/career-advice/wp-content/uploads/2018/06/What-is-it-like-working-in-IT-e1651761435165.jpg",
                date = "10 августа",
                location = "Кожевенная линия, 40",
                onClick = {})
        }
    }
}