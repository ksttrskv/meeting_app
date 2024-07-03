@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.wbtechnoschoollesson2.navigation

import com.example.wbtechnoschoollesson2.Molecules.MeetingCard
import com.example.wbtechnoschoollesson2.Molecules.ProfileAvatar
import com.example.wbtechnoschoollesson2.organism.TopBar1
import com.example.wbtechnoschoollesson2.organism.TopBar2
import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wbtechnoschoollesson2.R
import com.example.wbtechnoschoollesson2.atoms.theme.UiTheme
import com.example.wbtechnoschoollesson2.atoms.theme.WBTechnoschoolLesson2Theme
import com.example.wbtechnoschoollesson2.uiKitScreen.ButtonIconLine
import com.example.wbtechnoschoollesson2.uiKitScreen.SearchView
import com.example.wbtechnoschoollesson2.uiKitScreen.TypographyLine1


data class Meeting(
    val title: String,
    val date: String,
    val location: String,
    val isFinished: Boolean
)

val meetings = listOf(
    Meeting("Developer meeting", "13.09.2024", "Москва", true),
    Meeting("Another meeting", "15.10.2024", "Санкт-Петербург", false),
    Meeting("Third meeting", "20.11.2024", "Новосибирск", false),
    Meeting("Developer meeting", "13.09.2024", "Москва", true),
    Meeting("Another meeting", "15.10.2024", "Санкт-Петербург", false),
    Meeting("Third meeting", "20.11.2024", "Новосибирск", false),
    Meeting("Developer meeting", "13.09.2024", "Москва", true),
    Meeting("Another meeting", "15.10.2024", "Санкт-Петербург", false),
    Meeting("Third meeting", "20.11.2024", "Новосибирск", false)
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Screen1() {
    var selectedTabIndex by remember { mutableStateOf(0) }
    val allMeetings = meetings
    val activeMeetings = meetings.filter { !it.isFinished }
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
        ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 24.dp, end = 24.dp)
                .background(Color.White)
        ) {
            item {
                TopBar1(title = "Встречи") {}
                Spacer(modifier = Modifier.size(10.dp))
            }

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
                                "ВСЕ ВСТРЕЧИ",
                                color = if (selectedTabIndex == 0) UiTheme.colors.brandColorDefault else UiTheme.colors.neutralWeak
                            )
                        }
                    )
                    Tab(modifier = Modifier.background(Color.White),
                        selected = selectedTabIndex == 1,
                        onClick = { selectedTabIndex = 1 },
                        text = {
                            Text(
                                "АКТИВНЫЕ",
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
                    isFinished = meeting.isFinished
                )
                Divider(color = UiTheme.colors.neutralLine, thickness = 1.dp)
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Screen2() {
    Box(modifier = Modifier.background(Color.White),) {
        Scaffold(modifier = Modifier.background(Color.White),
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = "Профиль",
                            style = UiTheme.typography.subheading1,
                            fontSize = 24.sp
                        )
                    },
                    colors = TopAppBarDefaults.topAppBarColors(Color.White),
                    navigationIcon = {
                        IconButton(onClick = { }) {
                            Icon(
                                painter = painterResource(id = R.drawable.back_icon),
                                contentDescription = "Back",
                                modifier = Modifier.size(24.dp)
                            )
                        }
                    },
                    actions = {
                        IconButton(
                            onClick = { }
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.icon_edit),
                                contentDescription = "Добавить",
                                modifier = Modifier.size(24.dp)
                            )
                        }

                    }
                )


            }
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 46.dp)
                    .background(Color.White)
            ) {
                Spacer(modifier = Modifier.size(46.dp))
                ProfileAvatar(
                    avatarResId = R.drawable.avatarpw1,
                    isEditing = false,
                    modifier = Modifier
                        .size(200.dp)
                )
                Spacer(modifier = Modifier.size(20.dp))
                TypographyLine1(
                    title = "Иван Иванов",
                    subTitle = "+7 952 812-22-00"
                )
                Spacer(modifier = Modifier.size(20.dp))
                ButtonIconLine(color = UiTheme.colors.brandColorDefault, enabled = true)
            }

        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Screen3() {
    var selectedTabIndex by remember { mutableStateOf(0) }
    val plannedMeetings = meetings.filter { !it.isFinished }
    val finishedMeetings = meetings.filter { it.isFinished }
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 24.dp, end = 24.dp)
                .background(Color.White)
        ) {
            item {
                TopBar2(title = "Мои встречи") {}
                Spacer(modifier = Modifier.size(10.dp))
            }

            item {
                TabRow(
                    selectedTabIndex = selectedTabIndex,
                    indicator = { tabPositions ->
                        TabRowDefaults.Indicator(
                            Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex]),
                            color = UiTheme.colors.brandColorDefault,

                            )
                    }
                ) {
                    Tab(modifier = Modifier.background(Color.White),
                        selected = selectedTabIndex == 0,
                        onClick = { selectedTabIndex = 0 },
                        text = {
                            Text(
                                "ЗАПЛАНИРОВАНО",
                                style = UiTheme.typography.bodyText1,
                                color = if (selectedTabIndex == 0) UiTheme.colors.brandColorDefault else UiTheme.colors.neutralWeak
                            )
                        }
                    )
                    Tab(modifier = Modifier.background(Color.White),
                        selected = selectedTabIndex == 1,
                        onClick = { selectedTabIndex = 1 },
                        text = {
                            Text(
                                "УЖЕ ПРОШЛИ",
                                style = UiTheme.typography.bodyText1,
                                color = if (selectedTabIndex == 1) UiTheme.colors.brandColorDefault else UiTheme.colors.neutralWeak
                            )
                        }
                    )
                }
                Spacer(modifier = Modifier.size(40.dp))
            }

            val itemsToShow = if (selectedTabIndex == 0) plannedMeetings else finishedMeetings
            items(itemsToShow) { meeting ->
                MeetingCard(
                    title = meeting.title,
                    painter = painterResource(id = R.drawable.avatar),
                    date = meeting.date,
                    location = meeting.location,
                    isFinished = meeting.isFinished
                )
                Divider(color = UiTheme.colors.neutralLine, thickness = 1.dp)
            }
        }
    }

}


@Preview(showBackground = true)
@Composable
fun PreviewScreen() {
    WBTechnoschoolLesson2Theme {
        Screen2()
    }
}







