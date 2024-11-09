package com.example.newUiKit.newScreens.MainScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.newUiKit.Theme.MyMeetingAppTheme
import com.example.newUiKit.molecules.Banner
import com.example.newUiKit.molecules.Heading
import com.example.newUiKit.molecules.MediumTagsList
import com.example.newUiKit.newScreens.MainScreen.components.CommunityCardLine
import com.example.newUiKit.newScreens.MainScreen.components.EventCardThinLine
import com.example.newUiKit.newScreens.MainScreen.components.EventCardWideColumn
import com.example.newUiKit.newScreens.MainScreen.components.EventCardWideLine
import com.example.newUiKit.newScreens.MainScreen.components.PersonCardline
import com.example.newUiKit.newScreens.MainScreen.components.SearchAndIconLine
import org.koin.androidx.compose.getViewModel

@Composable
fun MainScreen(navController: NavController, viewModel: MainScreenViewModel = getViewModel()) {
    val events by viewModel.events.observeAsState(emptyList())
    val communities by viewModel.communities.observeAsState(emptyList())
    val upComingCommunityEvents by viewModel.upComingCommunityEvents.observeAsState(emptyList())

    val tags = listOf(
        "Дизайн", "Разработка", "Продакт менеджмент", "Проджект менеджмент",
        "Backend", "Frontend", "Mobile", "Тестирование", "Продажи",
        "Бизнес", "Безопасность", "Web", "Девопс", "Маркетинг", "Аналитика"
    )

    Box(
        Modifier
            .padding(top = 48.dp)
            .fillMaxSize()
    ) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(40.dp)
        ) {
            item {

                SearchAndIconLine(navController = navController)

                Spacer(modifier = Modifier.height(20.dp))
                EventCardWideLine(
                    navController = navController,
                    events = events
                ) //Лайн для укорочения кода
            }
            item {
                Column {
                    Heading(
                        text = "Ближайшие встречи",
                        modifier = Modifier.padding(start = 16.dp)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    EventCardThinLine(
                        navController = navController,
                        events = events
                    ) //Лайн для укорочения кода
                }
            }
            item {
                Column {
                    Heading(
                        text = "Сообщества для тестировщиков",
                        modifier = Modifier.padding(start = 16.dp)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    CommunityCardLine(
                        navController = navController,
                        communities = communities
                    ) //Лайн для укорочения кода
                }
            }
            item {
                Column {
                    Heading(
                        text = "Другие встречи",
                        modifier = Modifier.padding(start = 16.dp)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    MediumTagsList(tags = tags, modifier = Modifier.padding(horizontal = 16.dp))
                }
            }

            item {
                EventCardWideColumn(
                    navController = navController,
                    events = events
                ) //Column для укорочения кода
            }

            item {
                Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp)) {
                    Banner(navController = navController)
                }
            }
            item {
                EventCardWideColumn(
                    navController = navController,
                    events = events
                ) //Column для укорочения кода
            }
            item {
                Column {
                    Heading(
                        text = "Вы можете их знать",
                        modifier = Modifier.padding(start = 16.dp)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    PersonCardline(navController = navController) //Лайн для укорочения кода
                }
            }
            item {
                EventCardWideColumn(
                    navController = navController,
                    events = events
                )
            }

            item {
                Column {
                    Heading(
                        text = "Сообщества для тестировщиков",
                        modifier = Modifier.padding(start = 16.dp)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    CommunityCardLine(navController = navController, communities = communities)
                }
            }
            item {
                EventCardWideColumn(
                    navController = navController,
                    events = events
                )
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