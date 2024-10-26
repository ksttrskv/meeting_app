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
import com.example.newUiKit.newTheme.MyMeetingAppTheme
import com.example.newUiKit.newTheme.MyUiTheme

@Composable
fun WbTextButton(
    content: @Composable () -> Unit = { },
//    btnColor: Color,
    textColor: Color,
    enabled: Boolean = false,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
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
    MyMeetingAppTheme {

        WbTextButton(
            content = { Text(text = "Button") },
//            btnColor = MyUiTheme.colors.newBrandDefault,
            textColor = MyUiTheme.colors.newBrandDefault,
            onClick = { /*TODO*/ }
        )


    }
}

