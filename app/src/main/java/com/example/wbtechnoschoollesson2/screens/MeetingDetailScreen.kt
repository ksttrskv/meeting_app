package com.example.wbtechnoschoollesson2.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.example.wbtechnoschoollesson2.Molecules.AvatarRow
import com.example.wbtechnoschoollesson2.R
import com.example.wbtechnoschoollesson2.atoms.buttons.WbSolidButton
import com.example.wbtechnoschoollesson2.atoms.chips.CustomFilterChip
import com.example.wbtechnoschoollesson2.atoms.theme.UiTheme
import com.example.wbtechnoschoollesson2.atoms.theme.WBTechnoschoolLesson2Theme


@Composable
fun MeetingDetailScreen(meeting: Meeting) {
    Box(modifier = Modifier.padding(start = 24.dp, end=24.dp)) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize()
        ) {
            Text(
                text = "${meeting.date} - ${meeting.location} ул. Громова, 4",
                style = UiTheme.typography.bodyText1,
                color = UiTheme.colors.neutralWeak
            )
            Spacer(modifier = Modifier.height(2.dp))
            Row {
                CustomFilterChip(text = "Python")
                CustomFilterChip(text = "Junior")
                CustomFilterChip(text = "Moscow")
            }
            Spacer(modifier = Modifier.height(12.dp))
            ImageWithFullScreenPreview(
                imageUrl = "https://i.postimg.cc/GmsT4jPq/map-image.png",
                placeholderResId = R.drawable.map_image

            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                maxLines = 13,
                text = LoremIpsum(120).values.first(),
                style = UiTheme.typography.metadata1,
                color = UiTheme.colors.neutralWeak
            )
            Spacer(modifier = Modifier.height(20.dp))
            AvatarRow(
                avatarResIds = listOf(
                    R.drawable.frame_3293,
                    R.drawable.frame_3293,
                    R.drawable.frame_3293,
                    R.drawable.frame_3293,
                    R.drawable.frame_3293,
                    R.drawable.frame_3293,

                    )
            )
            Spacer(modifier = Modifier.height(13.dp))
            WbSolidButton(
                modifier = Modifier.fillMaxWidth(),
                content = { Text(text = "Пойду на встречу!") },
                btnColor = UiTheme.colors.brandColorDefault,
                textColor = Color.White,
                onClick = { /*TODO*/ },
                enabled = true
            )
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


@Preview(showBackground = true)
@Composable
fun PreviewMeetingDetailScreen() {
    val meeting = Meeting(
        title = "Developer meeting",
        date = "13.09.2024",
        location = "Москва",
        isFinished = true
    )
    WBTechnoschoolLesson2Theme {
        MeetingDetailScreen(meeting = meeting)
    }
}
