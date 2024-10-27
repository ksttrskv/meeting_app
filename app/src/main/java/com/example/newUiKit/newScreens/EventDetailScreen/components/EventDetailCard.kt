package com.example.newUiKit.newScreens.EventDetailScreen.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.newUiKit.Theme.MyMeetingAppTheme
import com.example.newUiKit.Theme.MyUiTheme
import com.example.newUiKit.molecules.MediumTagsList

@Composable
fun EventDetailCard(
    eventTitle: String,
    textStyle: TextStyle = MyUiTheme.typography.H1,
    imageUrl: String,
    date: String,
    location: String,
    modifier: Modifier = Modifier
) {
    val tags = listOf(
        "Backend", "Тестирование", "Разработка"
    )
    Card(

        colors = CardDefaults.cardColors(Color.Transparent),
        modifier = modifier
    ) {

        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Image(
                painter = rememberAsyncImagePainter(imageUrl),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .size(267.dp)
                    .clip(RoundedCornerShape(16.dp)),
                contentScale = ContentScale.Crop,
                alignment = Alignment.TopStart
            )
            Column {
                Text(
                    text = eventTitle,
                    style = textStyle,
                    color = MyUiTheme.colors.blackColor
                )
                Text(
                    text = "$date · $location",
                    style = MyUiTheme.typography.Secondary,
                    color = MyUiTheme.colors.secondaryColor,
                )
                MediumTagsList(tags = tags)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewMeetingCard() {
    MyMeetingAppTheme {
        EventDetailCard(
            eventTitle = "Python days",
            imageUrl = "https://ibb.co/6w71wQW",
            date = "10 августа",
            location = "Кожевенная линия, 40",
        )

    }
}