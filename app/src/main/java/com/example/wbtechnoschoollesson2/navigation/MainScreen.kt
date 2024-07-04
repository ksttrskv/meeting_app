
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
import com.example.wbtechnoschoollesson2.organism.BottomNavigation
import com.example.wbtechnoschoollesson2.navigation.Screen1
import com.example.wbtechnoschoollesson2.navigation.Screen2
import com.example.wbtechnoschoollesson2.navigation.Screen3
import com.example.wbtechnoschoollesson2.atoms.theme.WBTechnoschoolLesson2Theme
import com.example.wbtechnoschoollesson2.organism.TopBar3

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

        Scaffold(
            topBar = {
                when (currentRoute) {
                    "screen_1" -> TopBar3(
                        title = "Мои встречи",
                        navigationIcon = {
                            IconButton(onClick = {  }) {
                                Icon(
                                    painter = painterResource(id = R.drawable.back_icon),
                                    contentDescription = "Back",
                                    modifier = Modifier.size(24.dp)
                                )
                            }
                        },
                    )

                    "screen_2" -> TopBar3(
                        title = "Профиль",
                        navigationIcon = {
                            IconButton(onClick = {  }) {
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

                    "screen_3" -> TopBar3(
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
                startDestination = "screen_1",
                modifier = Modifier.padding(paddingValues)
            ) {
                composable("screen_1") { Screen1() }
                composable("screen_2") { Screen2() }
                composable("screen_3") { Screen3() }
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