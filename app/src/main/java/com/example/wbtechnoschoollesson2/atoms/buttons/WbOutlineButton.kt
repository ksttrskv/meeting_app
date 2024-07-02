package com.example.wbtechnoschoollesson2.atoms.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wbtechnoschoollesson2.atoms.theme.UiTheme
import com.example.wbtechnoschoollesson2.atoms.theme.WBTechnoschoolLesson2Theme

@Composable
fun WbOutlineButton(
    content: @Composable () -> Unit = { DefaultButtonContent() },
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
            .padding(8.dp),
        onClick = onClick,
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = Color.Transparent,
            contentColor = textColor,
            disabledContentColor = disabledTextColor,

        ),
        border = BorderStroke(
            width = 1.dp,
            color = disabledBorderColor,

        ),
        enabled = enabled,

    ) {
        content()
    }
}
@Composable
fun WbOutlineIconButton(
    icon: Painter,
    btnColor: Color,
    enabled: Boolean = true,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val disabledBorderColor = btnColor.copy(alpha = 0.5f)
    val iconTintColor = if (enabled) btnColor else btnColor.copy(alpha = 0.5f)
    Button(
        modifier = modifier
            .padding(8.dp),
        onClick = onClick,
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = Color.Transparent,
            contentColor = btnColor,
            disabledContentColor = iconTintColor
        ),
        border = BorderStroke(
            width = 1.dp,
            color = btnColor
        ),
        enabled = enabled,

        ) {
        Icon(
            painter = icon,
            modifier = Modifier.size(20.dp),
            contentDescription = null,
            tint = iconTintColor
        )
    }
}

@Composable
fun DefaultButtonContent() {
    Text(
        text = "text",
        style = UiTheme.typography.subheading2
    )
}



@Preview(showBackground = true)
@Composable
fun GreetingOutlinePreview() {
    WBTechnoschoolLesson2Theme {
        Row {
            WbOutlineButton(
                content = { Text(text = "Button")},
                btnColor = UiTheme.colors.brandColorDefault,
                textColor = UiTheme.colors.brandColorDefault,
                onClick = { /*TODO*/ }
            )
        }

    }
}

