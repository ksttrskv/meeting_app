package com.example.newUiKit.newScreens.MainScreenPackage

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.newUiKit.NewMolecules.EventCardWide
import com.example.wbtechnoschoollesson2.R

@Composable
fun EventCardWideColumn() {
    Column(verticalArrangement = Arrangement.spacedBy(40.dp)) {
        EventCardWide(
            title = "Как повышать грейд. Лекция Павла Хорикова",
            painter = painterResource(id = R.drawable.test_image_6),
            date = "Завтра",
            location = "Невский проспект, 11",
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 16.dp)
        )

        EventCardWide(
            title = "Андроидкор QA 2024",
            painter = painterResource(id = R.drawable.test_image_5),
            date = "Завтра",
            location = "Невский проспект, 11",
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 16.dp)
        )

        EventCardWide(
            title = "Путь в IT для школьников",
            painter = painterResource(id = R.drawable.test_image_2),
            date = "18 августа",
            location = "наб. канала Грибоедова, 133",
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 16.dp)
        )
    }
}
