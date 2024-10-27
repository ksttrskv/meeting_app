package com.example.newUiKit.molecules

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.newUiKit.Theme.MyMeetingAppTheme
import com.example.newUiKit.Theme.MyUiTheme
import com.example.newUiKit.buttons.SubscribeButton


@Composable
fun CommunityCard(
    title: String,
    imageRes: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {

    var isSubscribe by remember { mutableStateOf(false) }
    Card(
        onClick = onClick,
        colors = CardDefaults.cardColors(Color.Transparent),
        modifier = modifier
    ) {

        Column(
            modifier = Modifier.width(104.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Image(
                painter = rememberAsyncImagePainter(imageRes),
                contentDescription = null,
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .size(104.dp),
                contentScale = ContentScale.Crop,
                alignment = Alignment.TopStart
            )
            Column {
                Text(
                    text = title,
                    style = MyUiTheme.typography.H4,
                    color = MyUiTheme.colors.blackColor,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                SubscribeButton(
                    onClick = { isSubscribe = !isSubscribe },
                    isSelected = isSubscribe

                )


            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewCommunityCard() {
    MyMeetingAppTheme {
        CommunityCard(
            title = "Супер тестировщики",
            imageRes = "",
            onClick = {})

    }
}