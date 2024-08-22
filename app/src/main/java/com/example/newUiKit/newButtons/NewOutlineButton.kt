package com.example.wbtechnoschoollesson2.atoms.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.newUiKit.newTheme.MyUiTheme
import com.example.newUiKit.newTheme.multiColorGradient
import com.example.wbtechnoschoollesson2.atoms.theme.WBTechnoschoolLesson2Theme

@Composable
fun NewOutlineButton(
    content: @Composable () -> Unit = { DefaultButtonContent1() },
    textColor: Color,
    enabled: Boolean = false,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val disabledTextColor = textColor.copy(alpha = 0.5f)
    Button(
        modifier = modifier
            .padding(8.dp)
            .background(brush = multiColorGradient(), shape = RoundedCornerShape(16.dp))
            .fillMaxWidth(),
        onClick = onClick,
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = Color.Transparent,
            contentColor = textColor,
            disabledContentColor = disabledTextColor,
        ),
        enabled = enabled,

        ) {
        content()
    }
}

@Composable
fun DefaultButtonContent1() {
    Text(
        text = "text",
        style = MyUiTheme.typography.H3
    )
}


@Preview(showBackground = true)
@Composable
fun GreetingNewOutlineButtonPreview() {
    WBTechnoschoolLesson2Theme {
        Row {
            NewOutlineButton(
                content = { Text(text = "Оплатить") },
                textColor = Color.White,
                onClick = { /*TODO*/ },
                enabled = true
            )
        }

    }
}

