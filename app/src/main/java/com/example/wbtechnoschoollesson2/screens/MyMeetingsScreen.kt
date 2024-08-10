
package com.example.wbtechnoschoollesson2.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.SecondaryIndicator
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.wbtechnoschoollesson2.Molecules.MeetingCard
import com.example.wbtechnoschoollesson2.R
import com.example.wbtechnoschoollesson2.atoms.theme.UiTheme
import com.example.wbtechnoschoollesson2.atoms.theme.WBTechnoschoolLesson2Theme
import com.example.wbtechnoschoollesson2.navigation.BottomNavigation
import com.example.wbtechnoschoollesson2.navigation.TopBar3
import com.example.wbtechnoschoollesson2.screens.ViewModels.MyMeetingViewModel
import org.koin.androidx.compose.getViewModel


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "SuspiciousIndentation")
@Composable
fun MyMeetingScreen(navController: NavController) {
    var selectedTabIndex by remember { mutableStateOf(0) }
    val viewModel: MyMeetingViewModel = getViewModel()
    val plannedMeetings by viewModel.plannedMeetings.collectAsState(initial = emptyList())
    val finishedMeetings by viewModel.finishedMeetings.collectAsState(initial = emptyList())
    Scaffold(
        topBar = {
            TopBar3(
                title = "Мои встречи",
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(
                            painter = painterResource(id = R.drawable.back_icon),
                            contentDescription = "Back",
                            modifier = Modifier.size(24.dp)
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
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding)
                .padding(horizontal = 24.dp)
                .background(Color.White)
        ) {
            item {
                TabRow(
                    selectedTabIndex = selectedTabIndex,
                    indicator = { tabPositions ->
                        SecondaryIndicator(
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
                    onClick = {
                        navController.navigate("meeting_detail/${meeting.title}") {
                            launchSingleTop = true
                        }
                    }
                )
                HorizontalDivider(thickness = 1.dp, color = UiTheme.colors.neutralLine)
            }
        }
    }

}
@Preview(showBackground = true)
@Composable
fun PreviewScreen() {
    WBTechnoschoolLesson2Theme {
        val navController = rememberNavController()
        MyMeetingScreen(navController=navController)
    }
}







