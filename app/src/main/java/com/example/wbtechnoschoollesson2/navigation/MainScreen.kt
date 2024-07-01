import Molecules.TopBar1
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.wbtechnoschoollesson2.navigation.BottomNavigation
import com.example.wbtechnoschoollesson2.navigation.Screen1
import com.example.wbtechnoschoollesson2.navigation.Screen2
import com.example.wbtechnoschoollesson2.navigation.Screen3
import com.example.wbtechnoschoollesson2.ui.theme.WBTechnoschoolLesson2Theme

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route


    Scaffold(
        topBar = {
            when (currentRoute) {
                "screen3" -> TopBar1(title = "Профиль", onAddClick = { /* handle add click */ })
                "screen2" -> TopBar1(title = "Сообщения", onAddClick = { /* handle add click */ })
                "screen1" -> TopBar1(title = "Встречи", onAddClick = { /* handle add click */ })
            }
        },
        bottomBar = { BottomNavigation(navController = navController) }
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