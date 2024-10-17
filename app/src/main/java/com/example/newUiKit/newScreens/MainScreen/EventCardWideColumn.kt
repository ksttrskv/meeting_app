package com.example.newUiKit.newScreens.MainScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.newUiKit.NewMolecules.EventCardWide
import com.example.newUiKit.navigation.Screens
import com.example.wbtechnoschoollesson2.R

@Composable
fun EventCardWideColumn(navController: NavController) {
    val events = listOf(
        EventData(
            title = "Как повышать грейд. Лекция Павла Хорикова",
            imageRes = R.drawable.test_image_6,
            date = "Завтра",
            location = "Невский проспект, 11"
        ),
        EventData(
            title = "Андроидкор QA 2024",
            imageRes = R.drawable.test_image_5,
            date = "Завтра",
            location = "Невский проспект, 11"
        ),
        EventData(
            title = "Путь в IT для школьников",
            imageRes = R.drawable.test_image_2,
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
                painter = painterResource(id = event.imageRes),
                date = event.date,
                location = event.location,
                onClick = {
                    navController.navigate("${Screens.EventDetailScreen}/${event.title}/${event.date}/${event.location}/${event.imageRes}") {
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
    val imageRes: Int,
    val date: String,
    val location: String
)
