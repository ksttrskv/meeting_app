package com.example.newUiKit.newScreens.CommunityDetailScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.newUiKit.NewMolecules.AvatarMembersRow
import com.example.newUiKit.NewMolecules.NewHeading
import com.example.newUiKit.NewMolecules.NewTopBar
import com.example.newUiKit.NewMolecules.members
import com.example.newUiKit.newScreens.MainScreen.EventCardThinLine
import com.example.newUiKit.newScreens.MainScreen.EventCardWideColumn
import com.example.newUiKit.newTheme.MyUiTheme
import com.example.newUiKit.newTheme.multiColorLinearGradient
import com.example.newUiKit.newTheme.multiColorLinearGradientWhite
import com.example.wbtechnoschoollesson2.R
import com.example.wbtechnoschoollesson2.atoms.buttons.NewCustomButton

@Composable
fun CommunityDetailScreen(
    navController: NavController,
    communityTitle: String,
    communityAvatarImage: Int,
//    tags: List<String> = listOf("Разработка", "Карьера", "Тестирование", "Дизайн", "Бизнес")
) {
    var isRegistered by remember { mutableStateOf(false) }
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
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    NewCustomButton(
                        content = {
                            // Изменяем текст в зависимости от состояния подписки
                            Text(text = if (isRegistered) "Вы подписаны" else "Подписаться")
                        },
                        textColor = if (isRegistered) MyUiTheme.colors.newBrandDefault else Color.White,
                        enabledGradient = if (isRegistered) multiColorLinearGradientWhite() else multiColorLinearGradient(),
                        disabledColor = Color.Gray,
                        enabled = true,
                        onClick = {
                            // Изменение состояния при нажатии
                            isRegistered = !isRegistered
                        }
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    // Показать дополнительный текст только если не подписан
                    if (!isRegistered) {
                        Text(
                            text = stringResource(R.string.text_under_the_subscribe_button),
                            style = MyUiTheme.typography.Secondary,
                            color = MyUiTheme.colors.newBrandDefault
                        )
                    }
//                SubscribeButtonAndText()
                }
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
