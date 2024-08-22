package com.example.wbtechnoschoollesson2.atoms.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp

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
