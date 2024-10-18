package com.example.newUiKit

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.newUiKit.newTheme.MyUiTheme
import com.example.newUiKit.newTheme.multiColorLinearGradient
import com.example.wbtechnoschoollesson2.atoms.theme.UiTheme
import com.example.wbtechnoschoollesson2.atoms.theme.WBTechnoschoolLesson2Theme

@Composable
fun SwitchItem(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
) {
    val interactionSource = remember { MutableInteractionSource() }
    Switch(
        checked = checked,
        enabled = true,
        colors = SwitchDefaults.colors(
            checkedThumbColor = UiTheme.colors.neutralOffWhite,
            checkedTrackColor = MyUiTheme.colors.newBrandDefault,
            uncheckedThumbColor = UiTheme.colors.neutralOffWhite,
            uncheckedTrackColor = UiTheme.colors.neutralWhite,
            uncheckedBorderColor = Color.Transparent
        ),
        onCheckedChange = { onCheckedChange(it) },
        thumbContent = {
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .size(20.dp)
                    .background(UiTheme.colors.neutralOffWhite)
            )
        },
        modifier = modifier
    )
}

@Composable
fun GradientSwitch(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    checkedTrackColor: Brush = multiColorLinearGradient(),
    uncheckedTrackColor: Brush = Brush.horizontalGradient(
        colors = listOf(
            Color.LightGray, Color.Gray
        )
    ),
    thumbColor: Color = Color.White,
    trackWidth: Dp = 48.dp, // Ширина трека
    trackHeight: Dp = 24.dp, // Высота трека
    thumbRadius: Dp = 12.dp // Радиус ползунка
) {
    val thumbPosition by animateFloatAsState(targetValue = if (checked) 1f else 0f)
    val circleRadius = remember { 14.dp }
    val interactionSource = remember { MutableInteractionSource() }

    Box(
        modifier = modifier
            .size(width = trackWidth, height = trackHeight)
            .background(color = Color.Transparent)
            .clickable(
                onClick = { onCheckedChange(!checked) },
                interactionSource = interactionSource,
                indication = null
            )
    ) {
        Canvas(modifier = Modifier.matchParentSize()) {
            val trackBrush = if (checked) checkedTrackColor else uncheckedTrackColor

            drawRoundRect(
                brush = trackBrush,
                size = Size(size.width, size.height),
                cornerRadius = CornerRadius(x = 18.dp.toPx(), y = 18.dp.toPx())
            )

            val thumbOffset = calculateThumbOffset(
                start = 13.dp.toPx(),
                stop = size.width - 13.dp.toPx(),
                fraction = thumbPosition
            )

            drawCircle(
                color = thumbColor,
                radius = thumbRadius.toPx(),
                center = Offset(x = thumbOffset, y = size.height / 2)
            )
        }
    }
}

private fun calculateThumbOffset(
    start: Float,
    stop: Float,
    fraction: Float,
): Float = start + (stop - start) * fraction

internal val buttonCommunityCardGradient = Brush.horizontalGradient(
    listOf(
        Color(0xFFFEF1FB), Color(0xFFFDF1FC), Color(0xFFFCF0FC), Color(0xFFFBF0FD),
        Color(0xFFF9EFFD), Color(0xFFF8EEFE), Color(0xFFF6EEFE), Color(0xFFF4EDFF)
    )
)

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    WBTechnoschoolLesson2Theme {
        Column {
            SwitchItem(checked = true, onCheckedChange = {})
            GradientSwitch(checked = true, onCheckedChange = {})
        }

    }
}