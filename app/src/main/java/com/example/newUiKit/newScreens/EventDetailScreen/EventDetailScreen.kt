package com.example.newUiKit.newScreens.EventDetailScreen

import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.newUiKit.NewMolecules.NewTopBar
import com.example.newUiKit.newTheme.MyUiTheme
import com.example.wbtechnoschoollesson2.R


@Composable
fun EventDetailScreen(
    navController: NavController,
    eventTitle: String,
    eventDate: String,
    eventLocation: String,
    eventImageRes: Int
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val eventTitle = navBackStackEntry?.arguments?.getString("eventTitle") ?: "Event"
    Scaffold(
        topBar = {
            NewTopBar(
                title = eventTitle,
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
        containerColor = Color.White
    ) { contentPadding ->
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(32.dp),
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(contentPadding)
        ) {

            item {
                EventDetailCard(
                    eventTitle = eventTitle,
                    painter = painterResource(id = eventImageRes),
                    date = eventDate,
                    location = eventLocation,
                    onClick = { /*TODO*/ })
            }
            item {
                Text(
                    text = "Узнайте, как расти в профессии, улучшать навыки и получать повышение. Практические советы и реальные кейсы. \n \nПавел поделится эффективными стратегиями карьерного роста и методикой развития профессиональных навыков в IT.",
                    style = MyUiTheme.typography.Secondary,
                )
            }
            item {
                LeadingInfoCard(
                    heading = stringResource(R.string.leader),
                    name = "Павел Хориков",
                    info = "Ведущий специалист по подбору персонала в одной из крупнейших IT-компаний в ЕС.",
                    avatarImage = painterResource(id = R.drawable.test_image_4)
                )
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun PreviewEventDetailScreen() {
//    MyMeetingAppTheme {
//        val navController = rememberNavController()
//        EventDetailScreen(navController = navController)
//    }
//}