package com.example.newUiKit.newScreens.EventDetailScreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.newUiKit.newTheme.MyMeetingAppTheme
import com.example.newUiKit.newTheme.MyUiTheme
import com.example.wbtechnoschoollesson2.R

@Composable
fun EventMapCard(
    title: String,
    textStyle: TextStyle = MyUiTheme.typography.H2,
    painter: Painter,
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
                color = MyUiTheme.colors.newBlackColor
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
            Image(
                painter = painter,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .clip(RoundedCornerShape(24.dp)),
                contentScale = ContentScale.Crop,
                alignment = Alignment.TopStart
            )

        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewEventMapCard() {
    MyMeetingAppTheme {
        EventMapCard(
            title = "Севкабель Порт, Кожевенная линия, 40 ",
            painter = painterResource(id = R.drawable.map),
            metroStation = "Приморская",
        )
    }
}