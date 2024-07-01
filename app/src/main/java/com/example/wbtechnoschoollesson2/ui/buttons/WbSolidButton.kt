package com.example.wbtechnoschoollesson2.ui.buttons

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wbtechnoschoollesson2.ui.theme.UiTheme
import com.example.wbtechnoschoollesson2.ui.theme.WBTechnoschoolLesson2Theme

@Composable
fun WbSolidButton(
    text: String,
    btnColor: Color,
    textColor: Color,
    enabled: Boolean = false,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val disabledColor = btnColor.copy(alpha = 0.5f) // Цвет для неактивной кнопки
    val disabledTextColor = textColor.copy(alpha = 0.5f) // Цвет текста для неактивной кнопки

    Button(
        modifier = modifier
            .padding(8.dp),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = btnColor,
            disabledContainerColor = disabledColor,
            contentColor = textColor,
            disabledContentColor = disabledTextColor
        ),
        enabled = enabled,
    ) {
        Text(
            text = text,
            color = Color.White
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WBTechnoschoolLesson2Theme {
        Row {
            WbSolidButton(
                text = "Button",
                btnColor = UiTheme.colors.brandColorDefault,
                textColor = Color.White,
                onClick = { /*TODO*/ }
            )
        }
    }
}
