package com.example.newUiKit.newButtons

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wbtechnoschoollesson2.atoms.buttons.DefaultButtonContent
import com.example.wbtechnoschoollesson2.atoms.theme.UiTheme
import com.example.wbtechnoschoollesson2.atoms.theme.WBTechnoschoolLesson2Theme

@Composable
fun WbTextButton(
    content: @Composable () -> Unit = { DefaultButtonContent() },
    btnColor: Color,
    textColor: Color,
    enabled: Boolean = false,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
//    val disabledTextColor = textColor.copy(alpha = 0.5f)
    Button(
        modifier = modifier
            .height(52.dp)
            .fillMaxWidth(),
        onClick = onClick,
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = Color.Transparent,
            contentColor = textColor,
//            disabledContentColor = disabledTextColor
        ),
        enabled = enabled,
    ) {
        content()
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingTextPreview() {
    WBTechnoschoolLesson2Theme {

        WbTextButton(
            content = { Text(text = "Button") },
            btnColor = UiTheme.colors.brandColorDefault,
            textColor = UiTheme.colors.brandColorDefault,
            onClick = { /*TODO*/ }
        )


    }
}

