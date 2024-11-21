package com.example.presentation.molecules

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.presentation.Theme.MyMeetingAppTheme
import com.example.presentation.Theme.MyUiTheme
import com.example.wbtechnoschoollesson2.R

@Composable
fun UserAvatar(
    imageUrl: String,
    isEditing: Boolean,
    size: Dp,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(size)
            .clip(CircleShape)
            .background(color = MyUiTheme.colors.neutralActive, shape = CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = rememberAsyncImagePainter(imageUrl),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(size)

        )

        if (isEditing) {
            Box(
                modifier = Modifier
                    .padding(size * 0.14f)
                    .size(size * 0.26f)
                    .clip(CircleShape)
                    .align(Alignment.BottomEnd)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.edit_plus_ic),
                    contentDescription = null,
                    tint = MyUiTheme.colors.neutralActive,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewProfileAvatar() {
    MyMeetingAppTheme {
        Row(verticalAlignment = Alignment.CenterVertically) {

            UserAvatar(
                imageUrl = "https://s3-alpha-sig.figma.com/img/fa6d/f816/18a1e0468b6f5978e2adb058a64935e6?Expires=1725840000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=kVYVZrIPvXSXMi4J8hfzMgICf6N25qN-mDsq4me18K7YjnMoTvONxhNu9LZvfTOqy02wnHmnrbTXCPOCbDQcxq77OnfHJ1SX12V3nGwB20~KY~66k7v8J8pGd06XlGjDOl4KsAsOUQ58B8wqdqaRJO3ddQtbbJVKxDFoMrcCE3Ni~oB-EMot3jldWrncMbiWdAnXCSCOPfwh7emYIUXLPlHcGNCq8Q7kne9dmBE0AAuMFWcs6Hwm8LVcBKiwBNDLoyngHWJqJCKQBLg1iut~t2dLELDk0MRbfFSYCbG~~9RQlaQBlgsfAiFA-KO4gof0~lDvxQ0AuXTD4EZHV26DeA_",
                isEditing = false,
                modifier = Modifier.padding(16.dp),
                size = 100.dp
            )

            Spacer(modifier = Modifier.size(16.dp))
            UserAvatar(
                imageUrl = "https://s3-alpha-sig.figma.com/img/fa6d/f816/18a1e0468b6f5978e2adb058a64935e6?Expires=1725840000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=kVYVZrIPvXSXMi4J8hfzMgICf6N25qN-mDsq4me18K7YjnMoTvONxhNu9LZvfTOqy02wnHmnrbTXCPOCbDQcxq77OnfHJ1SX12V3nGwB20~KY~66k7v8J8pGd06XlGjDOl4KsAsOUQ58B8wqdqaRJO3ddQtbbJVKxDFoMrcCE3Ni~oB-EMot3jldWrncMbiWdAnXCSCOPfwh7emYIUXLPlHcGNCq8Q7kne9dmBE0AAuMFWcs6Hwm8LVcBKiwBNDLoyngHWJqJCKQBLg1iut~t2dLELDk0MRbfFSYCbG~~9RQlaQBlgsfAiFA-KO4gof0~lDvxQ0AuXTD4EZHV26DeA_",
                isEditing = true,
                modifier = Modifier.padding(16.dp),
                size = 100.dp
            )
        }
    }
}