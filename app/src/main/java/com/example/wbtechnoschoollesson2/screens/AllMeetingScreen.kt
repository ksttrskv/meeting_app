@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.wbtechnoschoollesson2.screens

import com.example.wbtechnoschoollesson2.Molecules.MeetingCard
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.wbtechnoschoollesson2.R
import com.example.wbtechnoschoollesson2.atoms.theme.UiTheme
import com.example.wbtechnoschoollesson2.navigation.BottomNavigation
import com.example.wbtechnoschoollesson2.navigation.TopBar3
import com.example.wbtechnoschoollesson2.screens.ViewModels.AllMeetingViewModel
import com.example.wbtechnoschoollesson2.uiKitScreen.SearchView
import org.koin.androidx.compose.getViewModel


@Composable
fun AllMeetingScreen(navController: NavController) {
    var selectedTabIndex by remember { mutableStateOf(0) }
    val viewModel: AllMeetingViewModel = getViewModel()
    val allMeetings by viewModel.allMeetings.collectAsState(initial = emptyList())
    val activeMeetings by viewModel.activeMeetings.collectAsState(initial = emptyList())
    Scaffold(
        topBar = {
            TopBar3(
                title = "Встречи",
                actions = {
                    IconButton(onClick = { }) {
                        Icon(
                            painter = painterResource(id = R.drawable.add_plus),
                            contentDescription = "Добавить",
                            tint = Color.Black,
                            modifier = Modifier.size(14.dp)
                        )
                    }
                },
            )
        },
        bottomBar = {
            BottomNavigation(navController = navController)
        },
        containerColor = Color.White

    ) { contentPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding)
                .background(Color.White)
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 24.dp, end = 24.dp)
                    .background(Color.White)
            ) {
                item {
                    SearchView()
                }
                item {
                    TabRow(
                        selectedTabIndex = selectedTabIndex,
                        indicator = { tabPositions ->
                            TabRowDefaults.Indicator(
                                Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex]),
                                color = UiTheme.colors.brandColorDefault
                            )
                        }
                    ) {
                        Tab(modifier = Modifier.background(Color.White),
                            selected = selectedTabIndex == 0,
                            onClick = { selectedTabIndex = 0 },
                            text = {
                                Text(
                                    stringResource(R.string.all_meetings_tabrow),
                                    color = if (selectedTabIndex == 0) UiTheme.colors.brandColorDefault else UiTheme.colors.neutralWeak
                                )
                            }
                        )
                        Tab(modifier = Modifier.background(Color.White),
                            selected = selectedTabIndex == 1,
                            onClick = { selectedTabIndex = 1 },
                            text = {
                                Text(
                                    stringResource(R.string.active_tabrow),
                                    style = UiTheme.typography.bodyText1,
                                    color = if (selectedTabIndex == 1) UiTheme.colors.brandColorDefault else UiTheme.colors.neutralWeak
                                )
                            }
                        )
                    }
                }

                val itemsToShow = if (selectedTabIndex == 0) allMeetings else activeMeetings
                items(itemsToShow) { meeting ->
                    MeetingCard(
                        title = meeting.title,
                        painter = painterResource(id = R.drawable.avatar),
                        date = meeting.date,
                        location = meeting.location,
                        isFinished = meeting.isFinished,
                        onClick = {
                            navController.navigate("meeting_detail/${meeting.title}") {
                                launchSingleTop = true
                            }
                        }
                    )
                    Divider(color = UiTheme.colors.neutralLine, thickness = 1.dp)
                }
            }
        }
    }
}