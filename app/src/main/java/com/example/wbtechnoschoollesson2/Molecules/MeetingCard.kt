package com.example.wbtechnoschoollesson2.Molecules

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wbtechnoschoollesson2.R
import com.example.wbtechnoschoollesson2.atoms.theme.UiTheme
import com.example.wbtechnoschoollesson2.atoms.theme.WBTechnoschoolLesson2Theme
import com.example.wbtechnoschoollesson2.uiKitScreen.ChipsLine


@Composable
fun MeetingCard(
    title: String,
    painter: Painter,
    date: String,
    location: String,
    isFinished: Boolean,
    onClick: () -> Unit
) {
    Card(
        onClick = onClick,
        modifier = Modifier.padding(4.dp),
        colors = CardDefaults.cardColors(Color.Transparent)
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .padding(top = 16.dp, bottom = 16.dp)
                .height(76.dp)
        ) {
            Column {
                Row {
                    Image(
                        painter = painter,
                        contentDescription = null,
                        modifier = Modifier.size(56.dp),
                        contentScale = ContentScale.Crop,
                        alignment = Alignment.TopStart
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Column {
                        Text(
                            text = title,
                            style = UiTheme.typography.bodyText1,
                            color = UiTheme.colors.neutralActive
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = "$date - $location",
                            style = UiTheme.typography.metadata1,
                            color = UiTheme.colors.neutralWeak,
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        ChipsLine()
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    if (isFinished) {
                        Text(
                            text = "Закончилась",
                            style = UiTheme.typography.metadata2,
                            color = UiTheme.colors.neutralWeak
                        )
                    }
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun PreviewMeetingCard() {
    WBTechnoschoolLesson2Theme {
        MeetingCard(
            title = "Developer meeting",
            painter = painterResource(id = R.drawable.avatar),
            date = "13.09.2024" ,
            location = "Москва",
            isFinished = true,
            onClick = {})

    }
}