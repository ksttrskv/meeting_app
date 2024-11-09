package com.example.newUiKit.newScreens.CommunityDetailScreen

import androidx.compose.foundation.clickable
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.newUiKit.Theme.MyUiTheme
import com.example.newUiKit.Theme.multiColorLinearGradient
import com.example.newUiKit.Theme.multiColorLinearGradientWhite
import com.example.newUiKit.molecules.AvatarMembersRow
import com.example.newUiKit.molecules.Heading
import com.example.newUiKit.molecules.TopBar
import com.example.newUiKit.navigation.Screens
import com.example.newUiKit.newScreens.CommunityDetailScreen.components.CommunityDetailCard
import com.example.newUiKit.newScreens.MainScreen.components.EventCardThinLine
import com.example.newUiKit.newScreens.MainScreen.components.EventCardWideColumn
import com.example.wbtechnoschoollesson2.R
import com.example.wbtechnoschoollesson2.atoms.buttons.CustomButton
import org.koin.androidx.compose.getViewModel

@Composable
fun CommunityDetailScreen(
    navController: NavController,
    communityTitle: String,
    communityAvatarImage: String,
    viewModel: CommunityDetailViewModel = getViewModel()
//    tags: List<String> = listOf("Разработка", "Карьера", "Тестирование", "Дизайн", "Бизнес")
) {
    val communityDetails by viewModel.communityDetails.observeAsState()
    val communityMembers by viewModel.communityMembers.observeAsState(emptyList())
    val upcomingCommunityEvents by viewModel.upcomingCommunityEvents.observeAsState(emptyList())
    val pastCommunityEvents by viewModel.pastCommunityEvents.observeAsState(emptyList())
    var isRegistered by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        viewModel.loadCommunityDetails()
        viewModel.loadCommunityMembers()
        viewModel.loadUpcomingCommunityEvents()
        viewModel.loadPastCommunityEvents()

    }
    Scaffold(
        topBar = {
            TopBar(
                title = communityTitle,
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
                            contentDescription = "Share",
                            modifier = Modifier.size(24.dp),
                            tint = MyUiTheme.colors.brandDefault
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
            communityDetails?.let { details ->
                item {
                    CommunityDetailCard(
                        communityTitle = communityTitle,
                        communityAvatar = communityAvatarImage,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                }
                item {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
                    ) {
                        CustomButton(
                            content = {
                                // Изменяем текст в зависимости от состояния подписки
                                Text(text = if (isRegistered) "Вы подписаны" else "Подписаться")
                            },
                            textColor = if (isRegistered) MyUiTheme.colors.brandDefault else Color.White,
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
                                color = MyUiTheme.colors.brandDefault
                            )
                        }
                    }
                }
                item {

                    Text(
                        text = details.description,
                        style = MyUiTheme.typography.Secondary,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                }
                item {
                    Heading(
                        text = stringResource(R.string.members),
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    AvatarMembersRow(
                        avatarPainters = communityMembers.map {
                            rememberAsyncImagePainter(model = it.painter)
                        },
                        modifier = Modifier
                            .padding(horizontal = 16.dp)
                            .clickable {
                                navController.navigate(Screens.MembersScreen) {
                                    launchSingleTop = true
                                }
                            }
                    )
                }
                item {
                    Heading(
                        text = stringResource(R.string.events),
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    EventCardWideColumn(
                        navController = navController,
                        events = upcomingCommunityEvents
                    )
                }
                item {
                    Heading(
                        text = stringResource(R.string.past_events),
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    EventCardThinLine(navController = navController, events = pastCommunityEvents)
                }
            }
        }
    }
}
