package com.example.newUiKit.newScreens.EventDetailScreen

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.example.newUiKit.Theme.MyUiTheme
import com.example.newUiKit.molecules.AvatarMembersRow
import com.example.newUiKit.molecules.Heading
import com.example.newUiKit.molecules.TopBar
import com.example.newUiKit.molecules.users
import com.example.newUiKit.navigation.Screens
import com.example.newUiKit.newScreens.EventDetailScreen.components.EventDetailCard
import com.example.newUiKit.newScreens.EventDetailScreen.components.EventMapCard
import com.example.newUiKit.newScreens.EventDetailScreen.components.LeadingInfoCard
import com.example.newUiKit.newScreens.EventDetailScreen.components.PopupButton
import com.example.newUiKit.newScreens.MainScreen.components.EventCardThinLine
import com.example.wbtechnoschoollesson2.R


@Composable
fun EventDetailScreen(
    navController: NavController,
    eventTitle: String,
    eventDate: String,
    eventLocation: String,
    eventImageRes: String
) {
//    val navBackStackEntry by navController.currentBackStackEntryAsState()
//    val eventTitle = navBackStackEntry?.arguments?.getString("eventTitle") ?: ""
    val lazyListState = rememberLazyListState()
    var previousIndex by remember { mutableStateOf(0) }
    var previousScrollOffset by remember { mutableStateOf(0) }
    var isRegistered by remember { mutableStateOf(false) }

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
    val avatarPainters = users.map { user ->
        rememberAsyncImagePainter(model = user.painter)
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
                    onRegistrationChange = { isRegistered = !isRegistered } // Обновляем состояние
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
            item {
                Text(
                    text = "Узнайте, как расти в профессии, улучшать навыки и получать повышение. Практические советы и реальные кейсы.  \nПавел поделится эффективными стратегиями карьерного роста и методикой развития профессиональных навыков в IT.",
                    style = MyUiTheme.typography.Secondary,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }
            item {
                LeadingInfoCard(
                    heading = stringResource(R.string.leader),
                    name = "Павел Хориков",
                    info = "Ведущий специалист по подбору персонала в одной из крупнейших IT-компаний в ЕС.",
                    avatarImage = painterResource(id = R.drawable.test_image_4),
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }
            item {
                EventMapCard(
                    title = "Севкабель Порт, Кожевенная линия, 40 ",
                    painter = painterResource(id = R.drawable.map),
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
                    avatarPainters = avatarPainters,
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
                    name = "The IT-Crowd",
                    info = "Сообщество профессионалов в сфере IT. Объединяем специалистов разных направлений для обмена опытом, знаниями и идеями.",
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
                EventCardThinLine(navController = navController)
            }
        }
    }

}


//item {
//    ImageWithFullScreenPreview(
//        imageUrl = "https://i.postimg.cc/GmsT4jPq/map-image.png",
//        placeholderResId = R.drawable.map_image
//    )
//    Spacer(modifier = Modifier.height(20.dp))
//}


@Composable
fun FullScreenImageDialog(
    imageUrl: String,
    onDismiss: () -> Unit,

    ) {
    Dialog(onDismissRequest = onDismiss) {
        val painter: Painter = rememberAsyncImagePainter(
            model = ImageRequest.Builder(LocalContext.current)
                .data(imageUrl)
                .size(Size.ORIGINAL)
                .build()
        )

        Image(
            painter = painter,
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .clickable { onDismiss() }
        )
    }
}

@Composable
fun ImageWithFullScreenPreview(
    imageUrl: String,
    placeholderResId: Int,
) {
    var showDialog by remember { mutableStateOf(false) }

    if (showDialog) {
        FullScreenImageDialog(imageUrl = imageUrl) {
            showDialog = false
        }
    }

    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data(imageUrl)
            .placeholder(placeholderResId)
            .error(placeholderResId)
            .build(),
        contentScale = ContentScale.Crop
    )

    Image(
        painter = painter,
        contentDescription = null,
        modifier = Modifier
            .fillMaxWidth()
            .height(175.dp)
            .clip(shape = RoundedCornerShape(30.dp))
            .clickable {
                Log.d("ImageWithFullScreenPreview", "Image clicked")
                showDialog = true
            },
        contentScale = ContentScale.Crop
    )
}