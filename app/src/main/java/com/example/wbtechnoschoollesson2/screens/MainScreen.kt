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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.wbtechnoschoollesson2.R
import com.example.wbtechnoschoollesson2.navigation.BottomNavigation
import com.example.wbtechnoschoollesson2.screens.Screen1
import com.example.wbtechnoschoollesson2.screens.Screen2
import com.example.wbtechnoschoollesson2.screens.Screen3
import com.example.wbtechnoschoollesson2.atoms.theme.WBTechnoschoolLesson2Theme
import com.example.wbtechnoschoollesson2.navigation.TopBar3
import com.example.wbtechnoschoollesson2.screens.CommunityScreen
import com.example.wbtechnoschoollesson2.screens.MoreScreen

@SuppressLint("SuspiciousIndentation")
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: "all_meetings"

    Scaffold(
        topBar = {
            when (currentRoute) {
                "my_meetings" -> TopBar3(
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

                "profile" -> TopBar3(
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

                "all_meetings" -> TopBar3(
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

                "more_screen" -> TopBar3(
                    title = "Еще",

                )

                "communities" -> TopBar3(
                    title = "Сообщества",
                )
            }
        },
        bottomBar = {
            BottomNavigation(
                navController = navController
            )
        },
        containerColor = Color.White
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = "all_meetings",
            modifier = Modifier.padding(paddingValues)
        ) {
            composable("my_meetings") { Screen1() }
            composable("profile") { Screen2() }
            composable("all_meetings") { Screen3() }
            composable("more_screen") { MoreScreen(navController = navController) }
            composable("communities") { CommunityScreen() }
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