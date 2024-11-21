package com.example.presentation.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.presentation.Theme.MyMeetingAppTheme
import com.example.presentation.Theme.MyUiTheme
import com.example.presentation.Theme.multiColorLinearGradientWhite
import com.example.wbtechnoschoollesson2.atoms.buttons.DefaultButtonContent1

@Composable
fun SolidButton(
    content: @Composable () -> Unit = { DefaultButtonContent1() },
    enabledGradient: Brush,
    enabled: Boolean = true,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
//            .fillMaxWidth()
            .height(34.dp)
            .width(174.dp)
            .background(
                brush = enabledGradient,
                shape = RoundedCornerShape(8.dp)
            )
            .clickable(enabled = enabled, onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        content()
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyMeetingAppTheme {
        SolidButton(
            content = {
                Text(
                    text = "Выбрать интересы",
                    style = MyUiTheme.typography.H5,
                    color = MyUiTheme.colors.brandDefault
                )
            },
            enabledGradient = multiColorLinearGradientWhite(),
            onClick = {},
        )
    }
}
