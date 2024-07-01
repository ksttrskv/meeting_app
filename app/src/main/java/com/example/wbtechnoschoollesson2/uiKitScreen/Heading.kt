package com.example.wbtechnoschoollesson2.uiKitScreen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.wbtechnoschoollesson2.ui.theme.UiTheme

@Composable
fun Heading(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier,
        text = text,
        style = UiTheme.typography.heading1
    )
}