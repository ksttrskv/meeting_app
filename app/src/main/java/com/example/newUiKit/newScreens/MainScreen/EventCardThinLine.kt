package com.example.newUiKit.newScreens.MainScreen

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
import com.example.newUiKit.NewMolecules.EventCardThin
import com.example.newUiKit.navigation.Screens

@Composable
fun EventCardThinLine(navController: NavController) {
    LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
        val events = listOf(
            EventData(
                title = "Python days",
                imageRes = "https://cached.imagescaler.hbpl.co.uk/resize/scaleWidth/1272/cached.offlinehbpl.hbpl.co.uk/news/OMP/GettyImages-1217856040-.jpg",
                date = "Завтра",
                location = "Невский проспект, 11"
            ),
            EventData(
                title = "QA Talks — Global tech forum",
                imageRes = "https://aif-s3.aif.ru/images/031/407/9386b82829ced1e10f1d769aa4542e52.jpg",
                date = "Завтра",
                location = "Невский проспект, 11",
            ),
            EventData(
                title = "QA Talks — Global tech forum",
                imageRes = "https://cached.imagescaler.hbpl.co.uk/resize/scaleWidth/1272/cached.offlinehbpl.hbpl.co.uk/news/OMP/GettyImages-1217856040-.jpg",
                date = "Завтра",
                location = "Невский проспект, 11",
            ),
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
            ),

            )


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