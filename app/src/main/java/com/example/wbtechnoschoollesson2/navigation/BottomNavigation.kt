package com.example.wbtechnoschoollesson2.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.wbtechnoschoollesson2.R
import com.example.wbtechnoschoollesson2.ui.theme.UiTheme
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView

@Composable
fun BottomNavigation(navController: NavController) {
    val listItems = listOf(
        BottomItem("Встречи", R.drawable.meeting_ic, "screen_1"),
        BottomItem("Профиль", R.drawable.ic_group, "screen_2"),
        BottomItem("Мои встречи", R.drawable.more_eshe, "screen_3")
    )

    NavigationBar(
        containerColor = Color.White,
        contentColor = Color.Black,
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
                            modifier = Modifier.size(32.dp)
                        )
                    }
                },
                label = {
                    if (currentRoute == item.route) {
                        Text(
                            text = item.title,
                            fontSize = 10.sp,
                            color = Color.Black
                        )
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
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.Black,
                    unselectedIconColor = Color.Gray,
                    selectedTextColor = Color.Black,
                    unselectedTextColor = Color.Gray
                )
            )
        }
    }
}
