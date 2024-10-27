package com.example.newUiKit.newScreens.MainScreen.components

import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.models.EventData
import com.example.newUiKit.molecules.EventCardWide
import com.example.newUiKit.navigation.Screens

@Composable
fun EventCardWideColumn(navController: NavController, events: List<EventData>) {
    // Перемешиваем список и берем максимум 3 элемента
    val randomEvents = events.shuffled().take(3)

    Column(
        verticalArrangement = Arrangement.spacedBy(40.dp),
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        randomEvents.forEach { event ->
            EventCardWide(
                title = event.title,
                imageUrl = event.imageRes,
                date = event.date,
                location = event.location,
                onClick = {
                    navController.navigate(
                        "${Screens.EventDetailScreen}/${Uri.encode(event.title)}/${Uri.encode(event.date)}/${
                            Uri.encode(event.location)
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

