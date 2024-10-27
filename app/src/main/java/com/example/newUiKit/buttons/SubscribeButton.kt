package com.example.newUiKit.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.newUiKit.Theme.MyMeetingAppTheme
import com.example.newUiKit.Theme.MyUiTheme
import com.example.newUiKit.Theme.multiColorLinearGradientWhite
import com.example.wbtechnoschoollesson2.R

@Composable
fun SubscribeButton(
    SubscribeFalseColor: Brush = multiColorLinearGradientWhite(), // Градиент для состояния невыбранной кнопки
    subscribeTrueColor: Color = MyUiTheme.colors.brandDefault, // Цвет из темы для выбранной кнопки
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .height(36.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        color = if (isSelected) subscribeTrueColor else Color.Transparent, // Цвет для выбранной кнопки
        border = if (!isSelected) BorderStroke(
            0.dp,
            SubscribeFalseColor
        ) else null, // Градиентная граница для невыбранной кнопки
        onClick = onClick,
        contentColor = Color.Transparent
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = if (!isSelected) SubscribeFalseColor else SolidColor(Color.Transparent),
                    shape = RoundedCornerShape(16.dp)
                )
        ) {
            // Контент внутри кнопки
            if (isSelected) {
                Image(
                    painter = painterResource(id = R.drawable.check_ic_new),
                    contentDescription = null,
                    modifier = Modifier.size(20.dp)
                )
            } else {
                Image(
                    painter = painterResource(id = R.drawable.plus_new),
                    contentDescription = null,
                    modifier = Modifier.size(20.dp)
                )
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun SubscribeButtonPreview() {
    MyMeetingAppTheme {
        Column {
            SubscribeButton(
                onClick = {},
                isSelected = true

            )
            SubscribeButton(
                onClick = {},
                isSelected = false

            )
        }

    }
}

