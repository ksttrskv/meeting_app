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
import com.example.domain.usecases.interfaces.GetCommunityUseCase
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
import com.example.wbtechnoschoollesson2.screens.MoreScreen
import com.example.wbtechnoschoollesson2.screens.MyMeetingScreen
import com.example.wbtechnoschoollesson2.screens.ProfileCreateScreen
import com.example.wbtechnoschoollesson2.screens.ProfileScreen
import com.example.wbtechnoschoollesson2.screens.Screens
import com.example.wbtechnoschoollesson2.screens.ViewModels.AllMeetingViewModel
import com.example.wbtechnoschoollesson2.screens.ViewModels.CommunityViewModel
import com.example.wbtechnoschoollesson2.screens.ViewModels.MeetingViewModel
import org.koin.androidx.compose.getViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun MainScreen(navController: NavController) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: ""
    val meetingViewModel: MeetingViewModel = koinViewModel()
    val isGoing by meetingViewModel.isGoing.collectAsState()
    val viewModel: CommunityViewModel = getViewModel()

    Scaffold(
        topBar = {
            when {

                currentRoute == Screens.MyMeetings -> TopBar3(
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

                currentRoute == Screens.Profile -> TopBar3(
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

                currentRoute == Screens.AllMeetings -> TopBar3(
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

                currentRoute == Screens.MoreScreen -> TopBar3(
                    title = "Еще",
                )

                currentRoute == Screens.Communitites -> TopBar3(
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
                currentRoute == Screens.Login -> TopBar3(
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
                currentRoute == Screens.CodeInput -> TopBar3(
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
                currentRoute == Screens.ProfileCreate -> TopBar3(
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
            if (currentRoute != Screens.Splash && currentRoute != Screens.Login && currentRoute != Screens.CodeInput && currentRoute != Screens.ProfileCreate && currentRoute != Screens.MeetingDetail) {
                BottomNavigation(navController = navController)
            }
        },
        containerColor = Color.White
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screens.Splash,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(Screens.Splash) {
                SplashScreen(navController = navController)
            }
            composable(Screens.MyMeetings) { AllMeetingScreen(navController = navController) }
            composable(Screens.Profile) { ProfileScreen() }
            composable(Screens.AllMeetings) { MyMeetingScreen() }
            composable(Screens.MoreScreen) { MoreScreen(navController = navController) }
            composable(Screens.Communitites) { CommunityScreen(navController = navController) }
            composable(
                route = "${Screens.CommunityDetail}/{communityTitle}",
                arguments = listOf(navArgument("communityTitle") { type = NavType.StringType })
            ) { backStackEntry ->
                val communityTitle = backStackEntry.arguments?.getString("communityTitle") ?: ""
                CommunityDetailScreen(communityTitle,navController)
            }
            composable(
                route = "${Screens.MeetingDetail}/{meeting}",
                arguments = listOf(navArgument("meeting") { type = NavType.StringType })
            ) { backStackEntry ->
                val meetingId = backStackEntry.arguments?.getString("meeting") ?: ""
                val meetingViewModel: MeetingViewModel = getViewModel()
                val meeting = meetingViewModel.getAllMeetings().find { it.title == meetingId }
                if (meeting != null) {
                    MeetingDetailScreen(meeting, navController, meetingViewModel)
                }
            }
            composable("custom_view") { CustomViewScreen() }
            composable(Screens.Login) { LoginScreen(navController = navController) }
            composable(Screens.CodeInput) { CodeInputScreen(navController = navController) }
            composable(Screens.ProfileCreate) { ProfileCreateScreen(navController = navController) }
        }
    }
}
