package com.example.newUiKit.newScreens.MainScreen

import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.newUiKit.NewMolecules.EventCardWide
import com.example.newUiKit.navigation.Screens

@Composable
fun EventCardWideColumn(navController: NavController) {
    val events = listOf(
        EventData(
            title = "Как повышать грейд. Лекция Павла Хорикова",
            imageRes = "https://lh3.googleusercontent.com/proxy/xErRF_3h-YgrklQQf7CSbwfzHDa43aexzr9JtquT6kzpEKgTDdLY39h0DAbBMtIqZ3HXC4JMT8lIeSVCXekPgi3vF4dpypL_9FjvQRitqtBe9VMSJr-cMibn2a8eTe7krOU",
            date = "Завтра",
            location = "Невский проспект, 11"
        ),
        EventData(
            title = "Андроидкор QA 2024",
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

    Column(
        verticalArrangement = Arrangement.spacedBy(40.dp),
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        events.forEach { event ->
            EventCardWide(
                title = event.title,
                imageUrl = event.imageRes,
                date = event.date,
                location = event.location,
                onClick = {
                    navController.navigate(
                        "${Screens.EventDetailScreen}/${Uri.encode(event.title)}/${Uri.encode(event.date)}/${
                            Uri.encode(
                                event.location
                            )
                        }/${Uri.encode(event.imageRes)}"
                    ) {
                        launchSingleTop = true
                    }
                },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

data class EventData(
    val title: String,
    val imageRes: String,
    val date: String,
    val location: String
)
