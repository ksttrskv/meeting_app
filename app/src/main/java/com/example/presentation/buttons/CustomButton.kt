package com.example.wbtechnoschoollesson2.atoms.buttons

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import com.example.presentation.Theme.MyMeetingAppTheme
import com.example.presentation.Theme.MyUiTheme
import com.example.presentation.Theme.multiColorLinearGradient
import com.example.presentation.Theme.multiColorLinearGradientWhite
import com.example.wbtechnoschoollesson2.R


@Composable
fun CustomButton(
    content: @Composable () -> Unit = { DefaultButtonContent1() },
    textColor: Color,
    disabledTextColor: Color = MyUiTheme.colors.newGray,
    enabledGradient: Brush,
    disabledColor: Color,
    enabled: Boolean = true,
    isLoading: Boolean = false,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val buttonModifier = modifier
        .fillMaxWidth()
        .let {
            if (enabled) {
                it.background(brush = enabledGradient, shape = RoundedCornerShape(16.dp))
            } else {
                it.background(color = disabledColor, shape = RoundedCornerShape(16.dp))
            }
        }


    Button(
        modifier = buttonModifier.height(50.dp),
        onClick = {
            if (!isLoading) {
                onClick()
            }
        },
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = Color.Transparent,
            contentColor = textColor,
            disabledContentColor = disabledTextColor,
        ),
        enabled = enabled
    ) {
        if (isLoading) {
            CircularProgressIndicator(
                color = textColor,
                strokeWidth = 2.dp,
            )
        } else {
            content()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CustomButtonPreview() {
    MyMeetingAppTheme {
        var isLoading by remember { mutableStateOf(false) }
        Column {
            CustomButton(
                content = {
                    Image(
                        painter = painterResource(id = R.drawable.plus_new),
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                },
                textColor = Color.White,
                disabledTextColor = MyUiTheme.colors.newGray,
                enabledGradient = multiColorLinearGradient(),
                disabledColor = Color.Gray,
                enabled = true,
                isLoading = isLoading,
                onClick = {},

            )
            CustomButton(
                content = { Text(text = "Оплатить") },
                textColor = MyUiTheme.colors.brandDefault,
                enabledGradient = multiColorLinearGradientWhite(),
                disabledColor = MyUiTheme.colors.offWhite,
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
