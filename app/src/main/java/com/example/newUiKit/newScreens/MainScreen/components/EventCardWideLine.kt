package com.example.newUiKit.newScreens.MainScreen.components

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
import com.example.newUiKit.molecules.EventCardWide
import com.example.newUiKit.navigation.Screens

@Composable
fun EventCardWideLine(navController: NavController) {

    val events = listOf(
        EventData(
            title = "Как повышать грейд. Лекция Павла Хорикова",
            imageRes = "https://lh3.googleusercontent.com/proxy/xErRF_3h-YgrklQQf7CSbwfzHDa43aexzr9JtquT6kzpEKgTDdLY39h0DAbBMtIqZ3HXC4JMT8lIeSVCXekPgi3vF4dpypL_9FjvQRitqtBe9VMSJr-cMibn2a8eTe7krOU",
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
