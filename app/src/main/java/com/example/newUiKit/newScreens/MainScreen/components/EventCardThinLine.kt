package com.example.newUiKit.newScreens.MainScreen.components

import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.models.EventData
import com.example.newUiKit.molecules.EventCardThin
import com.example.newUiKit.navigation.Screens
import java.util.UUID

@Composable
fun EventCardThinLine(
    navController: NavController, events: List<EventData> = listOf(
        EventData(
            title = "Python days",
            imageRes = "https://cached.imagescaler.hbpl.co.uk/resize/scaleWidth/1272/cached.offlinehbpl.hbpl.co.uk/news/OMP/GettyImages-1217856040-.jpg",
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
) {
    LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp)) {

        itemsIndexed(events) { index, event ->
            EventCardThin(
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
                    .padding(start = if (index == 0) 16.dp else 0.dp) // Паддинг для первого элемента
                    .height(264.dp)
            )
        }
    }
}
