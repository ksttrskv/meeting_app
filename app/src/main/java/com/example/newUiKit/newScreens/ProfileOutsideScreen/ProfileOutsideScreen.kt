package com.example.newUiKit.newScreens.ProfileOutsideScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.newUiKit.Theme.MyUiTheme
import com.example.newUiKit.molecules.Heading
import com.example.newUiKit.molecules.TopBar
import com.example.newUiKit.newScreens.MainScreen.components.CommunityCardLine
import com.example.newUiKit.newScreens.MainScreen.components.EventCardThinLine
import com.example.newUiKit.newScreens.ProfileOutsideScreen.components.ProfileInfoCard
import com.example.wbtechnoschoollesson2.R

@Composable
fun ProfileOutsideScreen(navController: NavController, title: String, image: String) {
    val tags = listOf("Тестирование", "Разработка", "Дизайн", "Продакт менеджер", "Бэкенд")

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),

        ) {
        item {
            Box {
                Image(
                    painter = rememberAsyncImagePainter(image),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(374.dp)
                )
                TopBar(
                    title = "",
                    navigationIcon = {
                        IconButton(onClick = { navController.navigateUp() }) {
                            Icon(
                                painter = painterResource(id = R.drawable.back),
                                contentDescription = "Back",
                                modifier = Modifier.size(24.dp),
                                tint = MyUiTheme.colors.brandDefault
                            )
                        }
                    },
                    actions = {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                painter = painterResource(id = R.drawable.share),
                                contentDescription = "",
                                tint = MyUiTheme.colors.brandDefault,
                            )
                        }

                    },
                )
            }

        }
        item {
            Spacer(modifier = Modifier.height(20.dp))
            ProfileInfoCard(
                name = title,
                location = "Москва",
                info = "Занимаюсь разработкой интерфейсов в eCom. Учу HTML, CSS и JavaScript",
                tags = tags,
                modifier = Modifier.padding(horizontal = 16.dp)

            )
        }
        item {
            Spacer(modifier = Modifier.height(40.dp))
            Heading(text = "Мои встречи", modifier = Modifier.padding(horizontal = 16.dp))
            Spacer(modifier = Modifier.height(10.dp))
            EventCardThinLine(navController = navController)
        }
        item {
            Spacer(modifier = Modifier.height(40.dp))
            Heading(text = "Мои сообщества", modifier = Modifier.padding(horizontal = 16.dp))
            Spacer(modifier = Modifier.height(10.dp))
            CommunityCardLine(navController = navController)
        }
        item {
            Spacer(modifier = Modifier.height(40.dp))
            Box(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Выйти",
                    style = MyUiTheme.typography.primary,
                    color = MyUiTheme.colors.secondaryColor,
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 28.dp)
                        .clickable { }
                )
            }

        }
    }

}


//@Preview(showBackground = true)
//@Composable
//fun PreviewProfileOutside() {
//    MyMeetingAppTheme {
//        val navcontroller = rememberNavController()
//        ProfileOutsideScreen(navController = navcontroller)
//    }
//}