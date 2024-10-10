package com.example.newUiKit.newScreens.MainScreenPackage

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.newUiKit.NewMolecules.PersonCard
import com.example.newUiKit.newTheme.MyMeetingAppTheme
import com.example.wbtechnoschoollesson2.R

@Composable
fun PersonCardline() {
    LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
        item {
            PersonCard(
                title = "Мария",
                painter = painterResource(id = R.drawable.user_avatar),
                onClick = {},
                modifier = Modifier.padding(start = 16.dp)
            )
        }
        item {
            PersonCard(
                title = "Ирина",
                painter = painterResource(id = R.drawable.user_avatar),
                onClick = {}
            )
        }
        item {
            PersonCard(
                title = "Никита",
                painter = painterResource(id = R.drawable.user_avatar),
                onClick = {}
            )
        }
        item {
            PersonCard(
                title = "Илья",
                painter = painterResource(id = R.drawable.user_avatar),
                onClick = {}
            )
        }
        item {
            PersonCard(
                title = "Кутакбах",
                painter = painterResource(id = R.drawable.user_avatar),
                onClick = {}
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PersonCardLinePreview() {
    MyMeetingAppTheme {
        PersonCardline()
    }
}