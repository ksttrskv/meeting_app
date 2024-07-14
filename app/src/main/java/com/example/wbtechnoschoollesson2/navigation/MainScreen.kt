package com.example.wbtechnoschoollesson2

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.wbtechnoschoollesson2.atoms.theme.UiTheme
import com.example.wbtechnoschoollesson2.navigation.BottomNavigation
import com.example.wbtechnoschoollesson2.navigation.TopBar3
import com.example.wbtechnoschoollesson2.screens.AllMeetingScreen
import com.example.wbtechnoschoollesson2.screens.CodeInputScreen
import com.example.wbtechnoschoollesson2.screens.CommunityDetailScreen
import com.example.wbtechnoschoollesson2.screens.CommunityScreen
import com.example.wbtechnoschoollesson2.screens.CustomViewScreen
import com.example.wbtechnoschoollesson2.screens.LoginScreen
import com.example.wbtechnoschoollesson2.screens.MeetingDetailScreen
import com.example.wbtechnoschoollesson2.screens.MeetingViewModel
import com.example.wbtechnoschoollesson2.screens.MoreScreen
import com.example.wbtechnoschoollesson2.screens.MyMeetingScreen
import com.example.wbtechnoschoollesson2.screens.ProfileCreateScreen
import com.example.wbtechnoschoollesson2.screens.ProfileScreen
import com.example.wbtechnoschoollesson2.screens.meetings
@Composable
fun MainScreen(navController: NavController) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: ""
    val meetingViewModel = remember { MeetingViewModel() }

    Scaffold(
        topBar = {
            when {
                currentRoute.startsWith("community_detail/") -> {
                    val communityTitle =
                        navBackStackEntry?.arguments?.getString("communityTitle") ?: "Сообщество"
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
                }

                currentRoute.startsWith("meeting_detail/") -> {
                    val meeting =
                        navBackStackEntry?.arguments?.getString("meeting") ?: "Встреча"
                    TopBar3(
                        title = meeting,
                        navigationIcon = {
                            IconButton(onClick = { navController.navigateUp() }) {
                                Icon(
                                    painter = painterResource(id = R.drawable.back_icon),
                                    contentDescription = "Back",
                                    modifier = Modifier.size(24.dp)
                                )
                            }
                        },
                        actions = {
                            if (meetingViewModel.isGoing.collectAsState().value) {
                                Icon(
                                    imageVector = ImageVector.vectorResource(id = R.drawable.check_ic),
                                    contentDescription = null,
                                    tint = UiTheme.colors.brandColorDefault,
                                    modifier = Modifier.size(18.dp)
                                )
                            }
                        }
                    )
                }

                currentRoute == "my_meetings" -> TopBar3(
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

                currentRoute == "profile" -> TopBar3(
                    title = "Профиль",
                    navigationIcon = {
                        IconButton(onClick = { navController.navigateUp() }) {
                            Icon(
                                painter = painterResource(id = R.drawable.back_icon),
                                contentDescription = "Back",
                                modifier = Modifier.size(24.dp)
                            )
                        }
                    },
                    actions = {
                        IconButton(onClick = { }) {
                            Icon(
                                painter = painterResource(id = R.drawable.icon_edit),
                                contentDescription = "Редактировать",
                                tint = Color.Black,
                                modifier = Modifier.size(18.dp)
                            )
                        }
                    },
                )

                currentRoute == "all_meetings" -> TopBar3(
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

                currentRoute == "more_screen" -> TopBar3(
                    title = "Еще",
                )

                currentRoute == "communities" -> TopBar3(
                    title = "Сообщества",
                )
                currentRoute == "custom_view" -> TopBar3(
                    title = "",
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
                currentRoute == "loginScreen" -> TopBar3(
                    title = "",
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
                currentRoute == "codeInputScreen" -> TopBar3(
                    title = "",
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
                currentRoute == "profileCreateScreen" -> TopBar3(
                    title = "Профиль",
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
            }
        },
        bottomBar = {
            if (currentRoute != "splash" && currentRoute != "loginScreen" && currentRoute != "codeInputScreen" && currentRoute != "profileCreateScreen") {
                BottomNavigation(navController = navController)
            }
        },
        containerColor = Color.White
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = "splash",
            modifier = Modifier.padding(paddingValues)
        ) {
            composable("splash") {
                SplashScreen(navController = navController)
            }
            composable("my_meetings") { AllMeetingScreen(navController = navController) }
            composable("profile") { ProfileScreen() }
            composable("all_meetings") { MyMeetingScreen() }
            composable("more_screen") { MoreScreen(navController = navController) }
            composable("communities") { CommunityScreen(navController = navController) }
            composable(
                route = "community_detail/{communityTitle}",
                arguments = listOf(navArgument("communityTitle") { type = NavType.StringType })
            ) { backStackEntry ->
                val communityTitle = backStackEntry.arguments?.getString("communityTitle") ?: ""
                CommunityDetailScreen(communityTitle)
            }
            composable(
                route = "meeting_detail/{meeting}",
                arguments = listOf(navArgument("meeting") { type = NavType.StringType })
            ) { backStackEntry ->
                val meetingId = backStackEntry.arguments?.getString("meeting") ?: ""
                val meeting = meetings.find { it.title == meetingId }
                if (meeting != null) {
                    MeetingDetailScreen(meeting, navController, meetingViewModel)
                }
            }
            composable("custom_view") { CustomViewScreen() }
            composable("loginScreen") { LoginScreen(navController = navController) }
            composable("codeInputScreen") { CodeInputScreen(navController = navController) }
            composable("profileCreateScreen") { ProfileCreateScreen(navController = navController) }
        }
    }
}
