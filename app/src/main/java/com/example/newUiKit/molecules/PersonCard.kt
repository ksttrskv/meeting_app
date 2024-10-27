package com.example.newUiKit.molecules

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.newUiKit.Theme.MyMeetingAppTheme
import com.example.newUiKit.Theme.MyUiTheme


@Composable
fun PersonCard(
    title: String,
    imageUrl: String,
    modifier: Modifier = Modifier,
    tag: String
) {

    Box(
        modifier = modifier.width(104.dp)
    ) {
        Column {
            Box(
                modifier = Modifier
                    .size(104.dp)
                    .clip(CircleShape)
                    .background(color = MyUiTheme.colors.neutralActive, shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = rememberAsyncImagePainter(model = imageUrl),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(104.dp)

                )
            }
            Spacer(modifier = Modifier.width(4.dp))

            Text(
                text = title,
                style = MyUiTheme.typography.primary,
                color = MyUiTheme.colors.blackColor,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(4.dp))
            SmallTag(text = tag, isSelected = false, onSelectedChange = {})

        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPersonCard() {
    MyMeetingAppTheme {
        PersonCard(
            title = "Крис",
            imageUrl = "https://www.fonvirtual.com/en/wp-content/uploads/2020/03/telecommuting-opt.jpg",
            tag = "Frontend"

        )
    }
}