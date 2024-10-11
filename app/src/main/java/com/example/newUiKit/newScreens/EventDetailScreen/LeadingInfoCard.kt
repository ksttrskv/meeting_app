package com.example.newUiKit.newScreens.EventDetailScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.example.newUiKit.newTheme.MyUiTheme

@Composable
fun LeadingInfoCard(
    heading: String,
    name: String,
    info: String,
    avatarImage: Painter,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth() // Занимает всю ширину
    ) {
        // Заголовок
        Text(
            text = heading,
            style = MyUiTheme.typography.H2,
            modifier = Modifier.padding(bottom = 16.dp) // Отступ снизу от заголовка
        )

        // Row с текстом и иконкой
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween, // Равномерное размещение между текстом и иконкой
        ) {
            // Колонка с текстом
            Column(
                modifier = Modifier.weight(1f) // Занимает оставшееся пространство
            ) {
                Text(
                    text = name,
                    style = MyUiTheme.typography.H4
                )
                Text(
                    text = info,
                    style = MyUiTheme.typography.Secondary
                )
            }

            // Иконка справа
            Image(
                painter = avatarImage,
                contentDescription = "user icon",
                modifier = Modifier
                    .size(104.dp)
                    .padding(start = 8.dp) // Отступ слева от иконки
                    .clip(RoundedCornerShape(16.dp)),
                contentScale = ContentScale.Crop,
                alignment = Alignment.TopEnd

            )
        }
    }
}