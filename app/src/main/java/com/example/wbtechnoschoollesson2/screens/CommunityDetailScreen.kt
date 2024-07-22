package com.example.wbtechnoschoollesson2.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.wbtechnoschoollesson2.Molecules.MeetingCard
import com.example.wbtechnoschoollesson2.R
import com.example.wbtechnoschoollesson2.atoms.theme.UiTheme
import com.example.wbtechnoschoollesson2.atoms.theme.WBTechnoschoolLesson2Theme
import com.example.wbtechnoschoollesson2.navigation.BottomNavigation
import com.example.wbtechnoschoollesson2.navigation.TopBar3
import com.example.wbtechnoschoollesson2.screens.ViewModels.MeetingViewModel
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json


@Composable
fun CommunityDetailScreen(communityTitle: String,navController: NavController, meetingViewModel: MeetingViewModel = viewModel()) {
//    val navController = rememberNavController()
    val meetings: List<Meeting> by remember {
        mutableStateOf(meetingViewModel.getAllMeetings())
    }
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val communityTitle = navBackStackEntry?.arguments?.getString("communityTitle") ?: "Сообщество"

    Scaffold(
        topBar = {
            TopBar3(
                title = communityTitle,
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(
                            painter = painterResource(id = R.drawable.back_icon),
                            contentDescription = "Back",
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
            )
        },
        bottomBar = {
//            BottomNavigation(navController = navController)
        },
        containerColor = Color.White
    ) { contentPadding ->
        LazyColumn(modifier = Modifier.padding(16.dp).padding(contentPadding)) {

            item {
                Text(
                    maxLines = 13,
                    text = LoremIpsum(120).values.first(),
                    style = UiTheme.typography.metadata1,
                    color = UiTheme.colors.neutralWeak
                )
            }
            item {
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Встречи сообщества",
                    style = UiTheme.typography.bodyText1,
                    color = UiTheme.colors.neutralWeak
                )
            }

            items(meetings) { meeting ->
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
}




//@Preview(showBackground = true)
//@Composable
//fun PreviewCommunityDetailScreen() {
//    val exampleCommunity = Community(
//        title = "Designa",
//        subtitle = "10 000 человек",
//        imageRes = R.drawable.communityavatar
//    )
//    WBTechnoschoolLesson2Theme {
//        CommunityDetailScreen(communityTitle = "Встречи")
//    }
//}