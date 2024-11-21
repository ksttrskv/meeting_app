package com.example.presentation.Screens.MainScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.presentation.Screens.MainScreen.components.CommunityCardLine
import com.example.presentation.Screens.MainScreen.components.EventCardThinLine
import com.example.presentation.Screens.MainScreen.components.EventCardWideColumn
import com.example.presentation.Screens.MainScreen.components.EventCardWideLine
import com.example.presentation.Screens.MainScreen.components.PersonCardline
import com.example.presentation.Screens.MainScreen.components.SearchAndIconLine
import com.example.presentation.Theme.MyMeetingAppTheme
import com.example.presentation.Theme.MyUiTheme
import com.example.presentation.molecules.Banner
import com.example.presentation.molecules.Heading
import com.example.presentation.molecules.MediumTagsList
import kotlinx.coroutines.launch
import org.koin.androidx.compose.getViewModel

@Composable
fun MainScreen(navController: NavController, viewModel: MainScreenViewModel = getViewModel()) {
    val events by viewModel.events.observeAsState(emptyList())
    val communities by viewModel.communities.observeAsState(emptyList())
//    val upComingCommunityEvents by viewModel.upComingCommunityEvents.observeAsState(emptyList())
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    val isButtonVisible by remember {
        derivedStateOf { listState.firstVisibleItemIndex > 0 }
    }
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
            state = listState,
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
        if (isButtonVisible) {
            SmallFloatingActionButton(
                onClick = {
                    coroutineScope.launch {
                        listState.animateScrollToItem(0) // Прокручиваем список к началу
                    }
                },
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(16.dp),
                containerColor = MyUiTheme.colors.offWhite,
                contentColor = Color.Transparent
            ) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowUp,
                    contentDescription = "Back to top",
                    tint = Color.White
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