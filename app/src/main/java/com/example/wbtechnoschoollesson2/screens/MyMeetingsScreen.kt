
package com.example.wbtechnoschoollesson2.screens

import com.example.wbtechnoschoollesson2.Molecules.MeetingCard
import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wbtechnoschoollesson2.R
import com.example.wbtechnoschoollesson2.atoms.theme.UiTheme
import com.example.wbtechnoschoollesson2.atoms.theme.WBTechnoschoolLesson2Theme
import com.example.wbtechnoschoollesson2.screens.ViewModels.MyMeetingViewModel
import org.koin.androidx.compose.getViewModel


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MyMeetingScreen() {
    var selectedTabIndex by remember { mutableStateOf(0) }
//    val plannedMeetings = meetings.filter { !it.isFinished }
//    val finishedMeetings = meetings.filter { it.isFinished }
    val viewModel: MyMeetingViewModel = getViewModel()
    val plannedMeetings by viewModel.plannedMeetings.collectAsState(initial = emptyList())
    val finishedMeetings by viewModel.finishedMeetings.collectAsState(initial = emptyList())

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 24.dp, end = 24.dp)
                .background(Color.White)
        ) {
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
                    isFinished = meeting.isFinished,
                    onClick = {}
                )
                Divider(color = UiTheme.colors.neutralLine, thickness = 1.dp)
            }
        }
    }




@Preview(showBackground = true)
@Composable
fun PreviewScreen() {
    WBTechnoschoolLesson2Theme {
        MyMeetingScreen()
    }
}







