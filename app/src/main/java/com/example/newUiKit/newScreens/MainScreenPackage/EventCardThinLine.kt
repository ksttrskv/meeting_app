package com.example.newUiKit.newScreens.MainScreenPackage

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.newUiKit.NewMolecules.EventCardThin
import com.example.wbtechnoschoollesson2.R

@Composable
fun EventCardThinLine() {
    LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
        item {
            EventCardThin(
                title = "Python days",
                painter = painterResource(id = R.drawable.pythondays),
                date = "10 августа",
                location = "Кожевенная линия, 40",
                onClick = {})
        }
        item {
            EventCardThin(
                title = "Турнир разработчиков «Белые ночи»",
                painter = painterResource(id = R.drawable.image_test_4),
                date = "10 августа",
                location = "Кожевенная линия, 40",
                onClick = {})
        }
        item {
            EventCardThin(
                title = "Python days",
                painter = painterResource(id = R.drawable.pythondays),
                date = "10 августа",
                location = "Кожевенная линия, 40",
                onClick = {})
        }
        item {
            EventCardThin(
                title = "Турнир разработчиков «Белые ночи»",
                painter = painterResource(id = R.drawable.image_test_4),
                date = "10 августа",
                location = "Кожевенная линия, 40",
                onClick = {})
        }
        item {
            EventCardThin(
                title = "Python days",
                painter = painterResource(id = R.drawable.pythondays),
                date = "10 августа",
                location = "Кожевенная линия, 40",
                onClick = {})
        }
        item {
            EventCardThin(
                title = "Турнир разработчиков «Белые ночи»",
                painter = painterResource(id = R.drawable.image_test_4),
                date = "10 августа",
                location = "Кожевенная линия, 40",
                onClick = {})
        }
    }
}