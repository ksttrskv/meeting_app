package com.example.newUiKit.newScreens.CommunityDetailScreen

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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.newUiKit.NewMolecules.AvatarMembersRow
import com.example.newUiKit.NewMolecules.NewHeading
import com.example.newUiKit.NewMolecules.NewTopBar
import com.example.newUiKit.NewMolecules.members
import com.example.newUiKit.newScreens.MainScreenPackage.EventCardThinLine
import com.example.newUiKit.newScreens.MainScreenPackage.EventCardWideColumn
import com.example.newUiKit.newTheme.MyUiTheme
import com.example.wbtechnoschoollesson2.R

@Composable
fun CommunityDetailScreen(
    navController: NavController,
    communityTitle: String,
    communityAvatarImage: Int,
//    tags: List<String> = listOf("Разработка", "Карьера", "Тестирование", "Дизайн", "Бизнес")
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val communityTitle = navBackStackEntry?.arguments?.getString("communityTitle") ?: ""
    Scaffold(
        topBar = {
            NewTopBar(
                title = communityTitle,
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
        containerColor = Color.White,

        ) { contentPadding ->
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(32.dp),
            modifier = Modifier
                .padding(contentPadding)
        ) {
            item {
                CommunityDetailCard(
                    communityTitle = communityTitle,
                    communityAvatar = painterResource(id = communityAvatarImage),
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }
            item {
                SubscribeButtonAndText()
            }
            item {
                Text(
                    text = "Сообщество профессионалов в сфере IT. Объединяем специалистов разных направлений для обмена опытом, знаниями и идеями.",
                    style = MyUiTheme.typography.Secondary,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }
            item {
                NewHeading(
                    text = stringResource(R.string.members),
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                AvatarMembersRow(
                    avatarResIds = members,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }
            item {
                NewHeading(
                    text = stringResource(R.string.events),
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                EventCardWideColumn(navController = navController)
            }
            item {
                NewHeading(
                    text = stringResource(R.string.past_events),
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                EventCardThinLine()
            }
        }
    }
}
