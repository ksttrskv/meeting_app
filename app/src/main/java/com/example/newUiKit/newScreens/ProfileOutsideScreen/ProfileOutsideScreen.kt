package com.example.newUiKit.newScreens.ProfileOutsideScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.newUiKit.NewMolecules.NewHeading
import com.example.newUiKit.NewMolecules.NewTopBar
import com.example.newUiKit.newScreens.MainScreenPackage.CommunityCardLine
import com.example.newUiKit.newScreens.MainScreenPackage.EventCardThinLine
import com.example.newUiKit.newTheme.MyMeetingAppTheme
import com.example.newUiKit.newTheme.MyUiTheme
import com.example.wbtechnoschoollesson2.R

@Composable
fun ProfileOutsideScreen(navController: NavController) {
    val tags = listOf("Тестирование", "Разработка", "Дизайн", "Продакт менеджер", "Бэкенд")

    Scaffold(
        topBar = {
            NewTopBar(
                title = "",
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(
                            painter = painterResource(id = R.drawable.back),
                            contentDescription = "Back",
                            modifier = Modifier.size(24.dp),
                            tint = MyUiTheme.colors.newBrandDefault
                        )
                    }
                },
                actions = {
                    Icon(
                        painter = painterResource(id = R.drawable.share),
                        contentDescription = "",
                        tint = MyUiTheme.colors.newBrandDefault,
                        modifier = Modifier.padding(end = 14.dp)
                    )
                },
//                cont = Color.Transparent, // Прозрачный цвет для топ-бара
//                elevation = 0.dp // Убираем тень
            )
        },
        containerColor = Color.Transparent
    ) { contentPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()

        ) {
            // Изображение аватарки на всю ширину, но не на всю длину
            Image(
                painter = painterResource(id = R.drawable.test_image_4),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(374.dp) // Высота изображения
            )

            // Основной контент под изображением
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(40.dp)

            ) {
                item {
                    ProfileInfoCard(
                        name = "Сергей",
                        location = "Москва",
                        info = "Занимаюсь разработкой интерфейсов в eCom. Учу HTML, CSS и JavaScript",
                        tags = tags
                    )
                }
                item {
                    NewHeading(text = "Мои встречи")
                    Spacer(modifier = Modifier.height(10.dp))
                    EventCardThinLine()
                }
                item {
                    NewHeading(text = "Мои сообщества")
                    Spacer(modifier = Modifier.height(10.dp))
                    CommunityCardLine(navController = navController)
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewProfileOutside() {
    MyMeetingAppTheme {
        val navcontroller = rememberNavController()
        ProfileOutsideScreen(navController = navcontroller)
    }
}