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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.wbtechnoschoollesson2.Molecules.ProfileAvatar
import com.example.wbtechnoschoollesson2.R
import com.example.wbtechnoschoollesson2.atoms.theme.UiTheme
import com.example.wbtechnoschoollesson2.atoms.theme.WBTechnoschoolLesson2Theme

data class MenuItem(
    val title: String,
    val icon: Painter,
    val route: String
)


@Composable
fun MoreScreen(navController: NavController) {
    val menuItems = listOf(
        MenuItem("Мои встречи", painterResource(R.drawable.meeting_ic), "my_meetings"),
        MenuItem("Профиль", painterResource(R.drawable.avatarpw), "profile"),
        MenuItem("Тема", painterResource(R.drawable.theme_ic), ""),
        MenuItem("Уведомления", painterResource(R.drawable.notifications_ic), ""),
        MenuItem("Безопасность", painterResource(R.drawable.security_ic), ""),
        MenuItem("Память и ресурсы", painterResource(R.drawable.resourse_ic), ""),
        MenuItem("Помощь", painterResource(R.drawable.help_ic), ""),
        MenuItem("Пригласи друга", painterResource(R.drawable.invite_ic), "")
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item {
            ProfileCard()
        }

        itemsIndexed(menuItems) { index, item ->
            if (index == 6) { // Индекс элемента
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


@Composable
fun ProfileCard() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable { /* Переход на экран профиля */ }
    ) {
        ProfileAvatar(
            avatarResId = R.drawable.avatarpw1,
            isEditing = false,
            size = 25.dp)
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text("Иван Иванов", style = UiTheme.typography.bodyText1,)
            Spacer(modifier = Modifier.height(8.dp))
            Text("+7 999 999-99-99", style = UiTheme.typography.metadata1)
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
            painter = item.icon,
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