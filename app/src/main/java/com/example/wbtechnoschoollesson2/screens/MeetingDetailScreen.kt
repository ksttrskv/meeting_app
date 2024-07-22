package com.example.wbtechnoschoollesson2.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.example.wbtechnoschoollesson2.R
import com.example.wbtechnoschoollesson2.atoms.buttons.WbOutlineButton
import com.example.wbtechnoschoollesson2.atoms.buttons.WbSolidButton
import com.example.wbtechnoschoollesson2.atoms.chips.CustomFilterChip
import com.example.wbtechnoschoollesson2.atoms.theme.UiTheme
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.domain.model.Meeting
import com.example.wbtechnoschoollesson2.Molecules.AvatarRow
import com.example.wbtechnoschoollesson2.navigation.TopBar3
import com.example.wbtechnoschoollesson2.screens.ViewModels.MeetingViewModel


@Composable
fun MeetingDetailScreen(
    meeting: Meeting,
    navController: NavController,
    meetingViewModel: MeetingViewModel
) {
    val isGoing by meetingViewModel.isGoing.collectAsState()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val meetingTitle = navBackStackEntry?.arguments?.getString("meeting") ?: ""

    Scaffold(
        topBar = {
            TopBar3(
                title = meetingTitle,
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(
                            painter = painterResource(id = R.drawable.back_icon),
                            contentDescription = "Back",
                            modifier = Modifier.size(24.dp)
                        )
                    }
                },
                actions = {
                    if (isGoing) {
                        Icon(
                            painter = painterResource(id = R.drawable.check_ic),
                            contentDescription = null,
                            tint = UiTheme.colors.brandColorDefault,
                            modifier = Modifier.size(30.dp)
                        )
                    }
                }
            )
        },
        bottomBar = {  },
        containerColor = Color.White

    ) { contentPadding ->
        Box(modifier = Modifier.padding(contentPadding).padding(start = 24.dp, end = 24.dp)) {
            LazyColumn(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxSize()
            ) {

                item {
                    Text(
                        text = "${meeting.date} - ${meeting.location} ул. Громова, 4",
                        style = UiTheme.typography.bodyText1,
                        color = UiTheme.colors.neutralWeak
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                }

                item {
                    LazyRow {
                        item {
                            CustomFilterChip(text = "Python")
                            CustomFilterChip(text = "Junior")
                            CustomFilterChip(text = "Moscow")
                        }
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                }

                item {
                    ImageWithFullScreenPreview(
                        imageUrl = "https://i.postimg.cc/GmsT4jPq/map-image.png",
                        placeholderResId = R.drawable.map_image
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                }

                item {
                    Text(
                        maxLines = 13,
                        text = LoremIpsum(120).values.first(),
                        style = UiTheme.typography.metadata1,
                        color = UiTheme.colors.neutralWeak
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                }

                item {
                    AvatarRow(
                        avatarResIds = listOf(
                            R.drawable.frame_3293,
                            R.drawable.frame_3293,
                            R.drawable.frame_3293,
                            R.drawable.frame_3293,
                            R.drawable.frame_3293,
                            R.drawable.frame_3293
                        )
                    )
                    Spacer(modifier = Modifier.height(13.dp))
                }

                item {
                    if (isGoing) {
                        WbOutlineButton(
                            modifier = Modifier.fillMaxWidth(),
                            content = { Text(text = "Схожу в другой раз") },
                            btnColor = UiTheme.colors.brandColorDefault,
                            textColor = UiTheme.colors.brandColorDefault,
                            onClick = { meetingViewModel.updateIsGoing() },
                            enabled = true
                        )
                    } else {
                        WbSolidButton(
                            modifier = Modifier.fillMaxWidth(),
                            content = { Text(text = "Пойду на встречу!") },
                            btnColor = UiTheme.colors.brandColorDefault,
                            textColor = Color.White,
                            onClick = { meetingViewModel.updateIsGoing() },
                            enabled = true
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun FullScreenImageDialog(
    imageUrl: String,
    onDismiss: () -> Unit
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
    placeholderResId: Int
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
            .build()
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
            }
    )
}