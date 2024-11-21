package com.example.presentation.Screens.EventDetailScreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.presentation.Theme.MyMeetingAppTheme
import com.example.presentation.Theme.MyUiTheme
import com.example.wbtechnoschoollesson2.R

@Composable
fun EventMapCard(
    title: String,
    textStyle: TextStyle = MyUiTheme.typography.H2,
//    painter: Painter,
    metroStation: String,
    modifier: Modifier = Modifier
) {
//    val tags = listOf(
//        "Backend", "Тестирование", "Разработка"
//    )
    Card(
        colors = CardDefaults.cardColors(Color.Transparent),
        modifier = modifier
    ) {

        Column {
            Text(
                text = title,
                style = textStyle,
                color = MyUiTheme.colors.blackColor
            )
            Spacer(modifier = Modifier.height(2.dp))
            Row {
                Image(
                    painter = painterResource(id = R.drawable.metro_img),
                    contentDescription = "Метро"
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "$metroStation",
                    style = MyUiTheme.typography.Secondary,
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
//            Image(
//                painter = painter,
//                contentDescription = null,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(180.dp)
//                    .clip(RoundedCornerShape(24.dp)),
//                contentScale = ContentScale.Crop,
//                alignment = Alignment.TopStart
//            )
            ImageWithFullScreenPreview(
                imageUrl = "https://i.postimg.cc/GmsT4jPq/map-image.png",
                placeholderResId = R.drawable.map
            )
            Spacer(modifier = Modifier.height(20.dp))

        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewEventMapCard() {
    MyMeetingAppTheme {
        EventMapCard(
            title = "Севкабель Порт, Кожевенная линия, 40 ",
//            painter = painterResource(id = R.drawable.map),
            metroStation = "Приморская",
        )
    }
}