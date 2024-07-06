package com.example.wbtechnoschoollesson2.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.wbtechnoschoollesson2.R
import com.example.wbtechnoschoollesson2.atoms.theme.UiTheme

data class BottomItem(val title:String, val iconId:Int, val route:String)

@Composable
fun BottomNavigation(navController: NavController) {
    val listItems = listOf(
        BottomItem("Сообщества", R.drawable.ic_group, "communities"),
        BottomItem("Еще", R.drawable.more_horizontal, "more_screen"),
        BottomItem("Встречи", R.drawable.meeting_ic, "all_meetings")
    )

    NavigationBar(
        containerColor = Color.White,
        contentColor = UiTheme.colors.neutralActive,
        tonalElevation = 8.dp,
        modifier = Modifier.height(60.dp)
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        listItems.forEach { item ->
            NavigationBarItem(
                icon = {
                    if (currentRoute != item.route) {
                        Icon(
                            painterResource(id = item.iconId),
                            contentDescription = item.title,
                            modifier = Modifier.size(32.dp),
                            tint = UiTheme.colors.neutralActive
                        )
                    }
                },
                label = {
                    if (currentRoute == item.route) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                text = item.title,
                                style = UiTheme.typography.bodyText1,
                                color = Color.Black
                            )
                            Box(
                                modifier = Modifier
                                    .padding(top = 4.dp)
                                    .size(4.dp)
                                    .background(UiTheme.colors.neutralActive, shape = CircleShape)

                            )
                        }

                    }
                },
                selected = currentRoute == item.route,
                onClick = {
                    if (currentRoute != item.route) {
                        navController.navigate(item.route) {
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                alwaysShowLabel = false
            )
        }
    }
}

