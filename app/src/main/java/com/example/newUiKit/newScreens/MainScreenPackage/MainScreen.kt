package com.example.newUiKit.newScreens.MainScreenPackage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.newUiKit.NewMolecules.Banner
import com.example.newUiKit.NewMolecules.NewHeading
import com.example.newUiKit.Tags.BigTagsList
import com.example.newUiKit.newTheme.MyMeetingAppTheme



@Composable
fun MainScreen(navController: NavController) {

    val tags = listOf(
        "Дизайн", "Разработка", "Продакт менеджмент", "Проджект менеджмент",
        "Backend", "Frontend", "Mobile", "Тестирование", "Продажи",
        "Бизнес", "Безопасность", "Web", "Девопс", "Маркетинг", "Аналитика"
    )

    Box(
        Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        LazyColumn(
            modifier = Modifier.padding(start = 16.dp),
            verticalArrangement = Arrangement.spacedBy(40.dp)
        ) {
            item {
//                Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
                    SearchAndIconLine()
//                }
                Spacer(modifier = Modifier.height(20.dp))
                EventCardWideLine() //Лайн для укорочения кода
            }
            item {
                Column {
                    NewHeading(text = "Ближайшие встречи")
                    Spacer(modifier = Modifier.height(16.dp))
                    EventCardThinLine() //Лайн для укорочения кода
                }
            }
            item {
                Column {
                    NewHeading(text = "Сообщества для тестировщиков")
                    Spacer(modifier = Modifier.height(16.dp))
                    CommunityCardLine() //Лайн для укорочения кода
                }
            }
            item {
                Column {
                    NewHeading(text = "Другие встречи")
                    Spacer(modifier = Modifier.height(16.dp))
                    BigTagsList(tags = tags)
                }
            }

            item {
                EventCardWideColumn() //Column для укорочения кода
            }

            item {
                Column(modifier = Modifier.padding(end = 16.dp)) {
                    Banner()
                }
            }
            item {
                EventCardWideColumn() //Column для укорочения кода
            }
            item {
                Column {
                    NewHeading(text = "Вы можете их знать")
                    Spacer(modifier = Modifier.height(16.dp))
                    PersonCardline() //Лайн для укорочения кода
                }
            }
            item {
                EventCardWideColumn() //Column для укорочения кода
            }

            item {
                Column {
                    NewHeading(text = "Сообщества для тестировщиков")
                    Spacer(modifier = Modifier.height(16.dp))
                    CommunityCardLine()
                }
            }
            item {
                EventCardWideColumn() //Column для укорочения кода
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    val navController = rememberNavController()
    MyMeetingAppTheme {
        MainScreen(navController = navController)
    }
}