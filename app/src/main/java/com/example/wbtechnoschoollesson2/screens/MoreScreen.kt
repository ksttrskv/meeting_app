package com.example.wbtechnoschoollesson2.screens


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.wbtechnoschoollesson2.Molecules.ProfileAvatar
import com.example.wbtechnoschoollesson2.R
import com.example.wbtechnoschoollesson2.atoms.theme.UiTheme
import com.example.wbtechnoschoollesson2.atoms.theme.WBTechnoschoolLesson2Theme
import com.example.wbtechnoschoollesson2.navigation.BottomNavigation
import com.example.wbtechnoschoollesson2.navigation.TopBar3
import com.example.wbtechnoschoollesson2.screens.ViewModels.MenuItem
import com.example.wbtechnoschoollesson2.screens.ViewModels.MoreScreenViewModel

@Composable
fun MoreScreen(navController: NavController) {

    val viewModel: MoreScreenViewModel = viewModel()
    val menuItems by viewModel.menuItems.collectAsState()
    Scaffold(
        topBar = {
            TopBar3(
                title = "Еще",
            )
        },
        bottomBar = {
            BottomNavigation(navController = navController)
        },
        containerColor = Color.White

    ) { contentPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(contentPadding)
                .fillMaxSize()
                .padding(16.dp)
        ) {
            item {
                ProfileCard(navController = navController)
            }

            itemsIndexed(menuItems) { index, item ->
                if (index == 5) { // Индекс элемента меню для разделителя
                    Divider(
                        color = UiTheme.colors.neutralLine,
                        thickness = 1.dp,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                }

                MenuItemRow(item, onClick = {
                    if (item.route.isNotEmpty()) {
                        navController.navigate(item.route)
                    }
                })
            }
        }
    }

}
@Composable
fun ProfileCard(navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable { navController.navigate("profile") }
    ) {
        ProfileAvatar(
            avatarResId = R.drawable.avatarpw1,
            isEditing = false,
            size = 25.dp)
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text("Иван Иванов", style = UiTheme.typography.bodyText1,)
            Spacer(modifier = Modifier.height(8.dp))
            Text("+7 999-99-99", style = UiTheme.typography.metadata1)
        }
    }
}

@Composable
fun MenuItemRow(item: MenuItem, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(16.dp)
    ) {
        Icon(
            painter = painterResource(id = item.iconResId),
            contentDescription = item.title,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(item.title, style = UiTheme.typography.bodyText1)
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            painter = painterResource(R.drawable.next_ic),
            contentDescription = null,
            modifier = Modifier.size(width = 8.dp, height = 12.dp),
            tint = UiTheme.colors.neutralActive
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMeetingCard() {
    WBTechnoschoolLesson2Theme {
        val navController = rememberNavController()
        MoreScreen(navController = navController)
    }
}
