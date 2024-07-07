import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.wbtechnoschoollesson2.R
import com.example.wbtechnoschoollesson2.navigation.BottomNavigation
import com.example.wbtechnoschoollesson2.screens.Screen1
import com.example.wbtechnoschoollesson2.screens.Screen2
import com.example.wbtechnoschoollesson2.screens.Screen3
import com.example.wbtechnoschoollesson2.atoms.theme.WBTechnoschoolLesson2Theme
import com.example.wbtechnoschoollesson2.navigation.TopBar3
import com.example.wbtechnoschoollesson2.screens.CommunityDetailScreen
import com.example.wbtechnoschoollesson2.screens.CommunityScreen
import com.example.wbtechnoschoollesson2.screens.Meeting
import com.example.wbtechnoschoollesson2.screens.MeetingDetailScreen
import com.example.wbtechnoschoollesson2.screens.MoreScreen
import com.example.wbtechnoschoollesson2.screens.meetings


@SuppressLint("SuspiciousIndentation")
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: "all_meetings"

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
                                modifier = Modifier.size(24.dp)
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
                                modifier = Modifier.size(24.dp)
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
            }
        },
        bottomBar = {
            BottomNavigation(navController = navController)
        },
        containerColor = Color.White
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = "all_meetings",
            modifier = Modifier.padding(paddingValues)
        ) {
            composable("my_meetings") { Screen1(navController = navController) }
            composable("profile") { Screen2() }
            composable("all_meetings") { Screen3() }
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
                    MeetingDetailScreen(meeting)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewScreen() {
    WBTechnoschoolLesson2Theme {
        MainScreen()
    }
}