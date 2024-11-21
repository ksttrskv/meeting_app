package com.example.presentation.Screens.MainScreen.components

import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.models.EventData
import com.example.presentation.molecules.EventCardWide
import com.example.presentation.navigation.Screens

@Composable
fun EventCardWideLine(navController: NavController, events: List<EventData>) {


    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        itemsIndexed(events) { index, event ->
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
                modifier = Modifier
                    .width(320.dp)
                    .height(305.dp)
                    .padding(start = if (index == 0) 16.dp else 0.dp) // Паддинг для первого элемента
            )
        }
        }
    }
