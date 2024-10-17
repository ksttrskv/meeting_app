package com.example.newUiKit.newScreens.MainScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.newUiKit.NewMolecules.EventCardWide
import com.example.newUiKit.newTheme.MyUiTheme
import com.example.wbtechnoschoollesson2.R

@Composable
fun EventCardWideLine() {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        item {
            EventCardWide(
                title = "QA Talks — Global tech forum",
                textStyle = MyUiTheme.typography.H1,
                painter = painterResource(id = R.drawable.eventcard_testimage),
                date = "Завтра",
                location = "Невский проспект, 11",
                onClick = {},
                modifier = Modifier
                    .width(320.dp)
                    .padding(start = 16.dp)
//                    .fillParentMaxWidth(0.9f) // Контент выходит за экран
            )
        }
        item {
            EventCardWide(
                title = "QA Talks — Global",
                textStyle = MyUiTheme.typography.H1,
                painter = painterResource(id = R.drawable.image_test_3),
                date = "Завтра",
                location = "Невский проспект, 11",
                onClick = {},
                modifier = Modifier.width(320.dp)
            )
        }
        item {
            EventCardWide(
                title = "QA Talks — Global tech forum",
                textStyle = MyUiTheme.typography.H1,
                painter = painterResource(id = R.drawable.eventcard_testimage),
                date = "Завтра",
                location = "Невский проспект, 11",
                onClick = {},
                modifier = Modifier.width(320.dp)
            )
        }
        item {
            EventCardWide(
                title = "QA Talks — Global",
                textStyle = MyUiTheme.typography.H1,
                painter = painterResource(id = R.drawable.image_test_3),
                date = "Завтра",
                location = "Невский проспект, 11",
                onClick = {},
                modifier = Modifier.width(320.dp)
            )
        }
        item {
            EventCardWide(
                title = "QA Talks — Global tech forum",
                textStyle = MyUiTheme.typography.H1,
                painter = painterResource(id = R.drawable.eventcard_testimage),
                date = "Завтра",
                location = "Невский проспект, 11",
                onClick = {},
                modifier = Modifier.width(320.dp)
            )
        }
        item {
            EventCardWide(
                title = "QA Talks — Global",
                textStyle = MyUiTheme.typography.H1,
                painter = painterResource(id = R.drawable.image_test_3),
                date = "Завтра",
                location = "Невский проспект, 11",
                onClick = {},
                modifier = Modifier.width(320.dp)
            )
        }
    }
}