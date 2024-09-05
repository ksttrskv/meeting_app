package com.example.newUiKit.newButtons

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
import com.example.newUiKit.newTheme.MyUiTheme
import com.example.newUiKit.newTheme.multiColorLinearGradientWhite
import com.example.wbtechnoschoollesson2.atoms.buttons.DefaultButtonContent1
import com.example.wbtechnoschoollesson2.atoms.theme.WBTechnoschoolLesson2Theme

@Composable
fun NewSolidButton(
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
    WBTechnoschoolLesson2Theme {
        NewSolidButton(
            content = {
                Text(
                    text = "Выбрать интересы",
                    style = MyUiTheme.typography.H5,
                    color = MyUiTheme.colors.newBrandDefault
                )
            },
            enabledGradient = multiColorLinearGradientWhite(),
            onClick = {},
        )
    }
}
