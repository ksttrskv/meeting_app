package com.example.presentation.Screens.EventDetailScreen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
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
import com.example.presentation.Screens.EventDetailScreen.components.EventDetailCard
import com.example.presentation.Screens.EventDetailScreen.components.EventMapCard
import com.example.presentation.Screens.EventDetailScreen.components.LeadingInfoCard
import com.example.presentation.Screens.EventDetailScreen.components.PopupButton
import com.example.presentation.Screens.MainScreen.components.EventCardThinLine
import com.example.presentation.Theme.MyUiTheme
import com.example.presentation.molecules.AvatarMembersRow
import com.example.presentation.molecules.Heading
import com.example.presentation.molecules.TopBar
import com.example.presentation.navigation.Screens
import com.example.wbtechnoschoollesson2.R
import org.koin.androidx.compose.getViewModel


@Composable
fun EventDetailScreen(
    navController: NavController,
    eventTitle: String,
    eventDate: String,
    eventLocation: String,
    eventImageRes: String,
    viewModel: EventDetailViewModel = getViewModel()
) {
    val lazyListState = rememberLazyListState()
    var previousIndex by remember { mutableStateOf(0) }
    var previousScrollOffset by remember { mutableStateOf(0) }

    val eventDetails by viewModel.eventDetails.observeAsState()
    val eventMembers by viewModel.eventMembers.observeAsState(emptyList())
    val communityEvents by viewModel.communityEvents.observeAsState(emptyList())
    val isRegistered by viewModel.isRegistered.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadEventDetail()
        viewModel.loadEventMembers()
        viewModel.loadCommunityEvents()
    }
    // Определяем, когда показать кнопку
    val shouldShowButton = remember {
        derivedStateOf {
            val isScrollingDown = lazyListState.firstVisibleItemIndex > previousIndex ||
                    (lazyListState.firstVisibleItemIndex == previousIndex &&
                            lazyListState.firstVisibleItemScrollOffset > previousScrollOffset)

            previousIndex = lazyListState.firstVisibleItemIndex
            previousScrollOffset = lazyListState.firstVisibleItemScrollOffset

            isScrollingDown
        }
    }
    Scaffold(
        topBar = {
            TopBar(
                title = eventTitle,
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
        containerColor = Color.Transparent,
        bottomBar = {
            // Анимация видимости кнопки и текста
            AnimatedVisibility(
                visible = shouldShowButton.value,
                enter = slideInVertically { it }, // Анимация появления снизу
                exit = slideOutVertically { it }, // Анимация скрытия
                modifier = Modifier
                    .fillMaxWidth()
                    .height(animateDpAsState(if (shouldShowButton.value) 110.dp else 0.dp).value) // Анимация высоты
            ) {
                PopupButton(
                    navController = navController,
                    isRegistered = isRegistered,
                    onRegistrationChange = { viewModel.toggleRegistration() } // Обновляем состояние
                )
            }
        }
    ) { contentPadding ->
        LazyColumn(
            state = lazyListState,
            verticalArrangement = Arrangement.spacedBy(32.dp),
            modifier = Modifier
                .padding(contentPadding)
        ) {

            item {
                EventDetailCard(
                    eventTitle = eventTitle,
                    imageUrl = eventImageRes,
                    date = eventDate,
                    location = eventLocation,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }
            eventDetails?.let { details ->
                item {
                    Text(
                        text = details.eventDescription,
                        style = MyUiTheme.typography.Secondary,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                }
                item {
                    LeadingInfoCard(
                        heading = stringResource(R.string.leader),
                        name = details.presenterName,
                        info = details.presenterInfo,
                        avatarImage = painterResource(id = R.drawable.test_image_4),
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                }
                item {
                    EventMapCard(
                        title = "Севкабель Порт, Кожевенная линия, 40 ",
                        metroStation = "Приморская",
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                }
                item {
                    Heading(
                        text = stringResource(R.string.members_of_event),
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    AvatarMembersRow(
                        avatarPainters = eventMembers.map {
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
                    LeadingInfoCard(
                        heading = stringResource(R.string.event_organizer),
                        name = details.organizerName,
                        info = details.organizerDescription,
                        avatarImage = painterResource(id = R.drawable.test_image_3),
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                }
                item {
                    Heading(
                        text = stringResource(R.string.other_community_meetings),
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    EventCardThinLine(
                        navController = navController,
                        events = communityEvents
                    )
                }
            }
        }
    }
}