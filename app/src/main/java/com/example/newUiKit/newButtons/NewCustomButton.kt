package com.example.wbtechnoschoollesson2.atoms.buttons

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.newUiKit.newTheme.MyUiTheme
import com.example.newUiKit.newTheme.multiColorLinearGradient
import com.example.newUiKit.newTheme.multiColorLinearGradientWhite
import com.example.wbtechnoschoollesson2.R
import com.example.wbtechnoschoollesson2.atoms.theme.WBTechnoschoolLesson2Theme


@Composable
fun NewCustomButton(
    content: @Composable () -> Unit = { DefaultButtonContent1() },
    textColor: Color,
    enabledGradient: Brush,
    disabledColor: Color,
    enabled: Boolean = true,
    isLoading: Boolean = false,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val buttonModifier = modifier
//        .padding(8.dp)
        .fillMaxWidth()
        .let {
            if (enabled) {
                it.background(brush = enabledGradient, shape = RoundedCornerShape(16.dp))
            } else {
                it.background(color = disabledColor, shape = RoundedCornerShape(16.dp))
            }
        }

    Button(
        modifier = buttonModifier,
        onClick = {
            if (!isLoading) {
                onClick()
            }
        },
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = Color.Transparent,
            contentColor = textColor,
            disabledContentColor = textColor.copy(alpha = 0.5f),
        ),
        enabled = enabled
    ) {
        if (isLoading) {
            CircularProgressIndicator(
                color = textColor,
                strokeWidth = 2.dp,
//                modifier = Modifier.size(24.dp)
            )
        } else {
            content()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CustomButtonPreview() {
    WBTechnoschoolLesson2Theme {
        var isLoading by remember { mutableStateOf(false) }
        Column {
            NewCustomButton(
                content = {
                    Image(
                        painter = painterResource(id = R.drawable.plus_new),
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                },
                textColor = Color.White,
                enabledGradient = multiColorLinearGradient(),
                disabledColor = Color.Gray,
                enabled = true,
                isLoading = isLoading,
                onClick = {},

            )
            NewCustomButton(
                content = { Text(text = "Оплатить") },
                textColor = MyUiTheme.colors.newBrandDefault,
                enabledGradient = multiColorLinearGradientWhite(),
                disabledColor = MyUiTheme.colors.newOffWhite,
                enabled = false,
                isLoading = isLoading,
                onClick = {},

            )
        }

    }
}

@Composable
fun DefaultButtonContent1() {
    Text(
        text = "text",
        style = MyUiTheme.typography.H3
    )
}
