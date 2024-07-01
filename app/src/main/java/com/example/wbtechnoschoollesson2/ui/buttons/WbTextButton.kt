package com.example.wbtechnoschoollesson2.ui.buttons

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
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
fun WbTextButton(
    text: String,
    btnColor: Color,
    textColor: Color,
    enabled: Boolean = false,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val disabledBorderColor = btnColor.copy(alpha = 0.5f)
    val disabledTextColor = textColor.copy(alpha = 0.5f)
    Button(
        modifier = modifier
            .height(52.dp)
            .width(144.dp),
        onClick = onClick,
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = Color.Transparent,
            contentColor = textColor,
            disabledContentColor = disabledTextColor
        ),
        enabled = enabled,
    ) {
        Text(
            text = text,
            color = if (enabled) textColor else disabledTextColor
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingTextPreview() {
    WBTechnoschoolLesson2Theme {
        Row {
            WbTextButton(
                text = "Button",
                btnColor = UiTheme.colors.brandColorDefault,
                textColor = UiTheme.colors.brandColorDefault,
                onClick = { /*TODO*/ }
            )
        }

    }
}

