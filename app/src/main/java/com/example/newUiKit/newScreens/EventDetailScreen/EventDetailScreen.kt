package com.example.newUiKit.newScreens.EventDetailScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.newUiKit.NewMolecules.EventCardWide
import com.example.newUiKit.NewMolecules.NewHeading
import com.example.newUiKit.NewMolecules.NewTopBar
import com.example.newUiKit.newTheme.MyMeetingAppTheme
import com.example.newUiKit.newTheme.MyUiTheme
import com.example.wbtechnoschoollesson2.R
import com.example.wbtechnoschoollesson2.navigation.BottomNavigation

@Composable
fun EventDetailScreen(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val title = navBackStackEntry?.arguments?.getString("title") ?: "Сообщество"
    Scaffold(
        topBar = {
            NewTopBar(
                title = "Как повышать грейд. Лекция...",
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
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.share),
                            contentDescription = "Share",
                            modifier = Modifier.size(24.dp),
                            tint = MyUiTheme.colors.newBrandDefault
                        )
                    }
                }
            )
        },
        bottomBar = {
            BottomNavigation(navController = navController)
        },
        containerColor = Color.White
    ) { contentPadding ->
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(32.dp),
            modifier = Modifier
                .padding(16.dp)
                .padding(contentPadding)
        ) {

            item {
                EventCardWide(
                    title = title,
                    painter = painterResource(id = R.drawable.test_avatar_user),
                    date = "11 november",
                    location = " Berlin",
                    onClick = { /*TODO*/ })
            }
            item {
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Узнайте, как расти в профессии, улучшать навыки и получать повышение. Практические советы и реальные кейсы. \n \nПавел поделится эффективными стратегиями карьерного роста и методикой развития профессиональных навыков в IT.",
                    style = MyUiTheme.typography.Secondary,
                )
            }
            item {
                NewHeading(text = "Ведущий")
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Павел Хориков",
                    style = MyUiTheme.typography.H4,
                )
                Text(
                    text = "Ведущий специалист по подбору персонала в одной из крупнейших IT-компаний в ЕС.",
                    style = MyUiTheme.typography.Secondary,
                )
            }


        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewEventDetailScreen() {
    MyMeetingAppTheme {
        val navController = rememberNavController()
        EventDetailScreen(navController = navController)
    }
}