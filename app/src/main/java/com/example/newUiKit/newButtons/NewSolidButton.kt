package com.example.newUiKit.newButtons

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.newUiKit.newTheme.multiColorGradient
import com.example.wbtechnoschoollesson2.atoms.buttons.DefaultButtonContent1
import com.example.wbtechnoschoollesson2.atoms.theme.WBTechnoschoolLesson2Theme

@Composable
fun NewSolidButton(
    isLoading: Boolean = false,
    content: @Composable () -> Unit = { DefaultButtonContent1() },
    textColor: Color,
    enabled: Boolean = false,
    onClick: () -> Unit, // Изменено: убрал @Composable
    modifier: Modifier = Modifier
) {
    val disabledTextColor = textColor.copy(alpha = 0.5f)

    Button(
        modifier = modifier
            .padding(8.dp)
            .background(brush = multiColorGradient(), shape = RoundedCornerShape(16.dp))
            .fillMaxWidth(),
        onClick = onClick, // Привязка onClick
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = Color.Transparent,
            contentColor = textColor,
            disabledContentColor = disabledTextColor,
        ),
        enabled = enabled,
    ) {
        if (isLoading) {
            CircularProgressIndicator(
                color = textColor,
                strokeWidth = 2.dp,
                modifier = Modifier.size(24.dp)
            )
        } else {
            content()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreviewOutline() {
    WBTechnoschoolLesson2Theme {
        var isLoading by remember { mutableStateOf(false) }

        NewSolidButton(
            isLoading = isLoading,
            content = { Text(text = "Оплатить") },
            textColor = Color.White,
            enabled = true,
            onClick = {
                isLoading = true
//                // Имитация загрузки с задержкой
//                LaunchedEffect(Unit) {
//                    delay(2000) // 2 секунды
                isLoading = false
//                }
            }
        )
    }
}
