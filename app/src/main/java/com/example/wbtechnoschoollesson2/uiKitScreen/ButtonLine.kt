package com.example.wbtechnoschoollesson2.uiKitScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.wbtechnoschoollesson2.R
import com.example.wbtechnoschoollesson2.atoms.buttons.WbOutlineButton
import com.example.wbtechnoschoollesson2.atoms.buttons.WbOutlineIconButton
import com.example.wbtechnoschoollesson2.atoms.buttons.WbSolidButton
import com.example.wbtechnoschoollesson2.atoms.buttons.WbTextButton

@Composable
fun ButtonLine(color: Color, enabled: Boolean, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        WbSolidButton(
            content = { Text(text = "Button")},
            btnColor = color,
            onClick = {},
            textColor = Color.White,
            enabled = enabled,
            modifier = Modifier.weight(1f)
        )

        WbOutlineButton(
            content = { Text(text = "Button")},
            btnColor = color,
            textColor = color,
            onClick = { },
            enabled = enabled,
            modifier = Modifier.weight(1f)
        )
        WbTextButton(
            content = { Text(text = "Button")},
            btnColor = color,
            textColor = color,
            onClick = { },
            enabled = enabled,
            modifier = Modifier.weight(1f)
        )
    }
}
@Composable
fun ButtonIconLine(color: Color, enabled: Boolean, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(12.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        WbOutlineIconButton(
            icon = painterResource(id = R.drawable.twitter),
            btnColor = color,
            onClick = { /*TODO*/ })
        WbOutlineIconButton(
            icon = painterResource(id = R.drawable.instagram),
            btnColor = color,
            onClick = { /*TODO*/ })
        WbOutlineIconButton(
            icon = painterResource(id = R.drawable.linkedin),
            btnColor = color,
            onClick = { /*TODO*/ })
        WbOutlineIconButton(
            icon = painterResource(id = R.drawable.coolicon),
            btnColor = color,
            onClick = { /*TODO*/ })

    }
}