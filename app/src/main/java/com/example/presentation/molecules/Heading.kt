package com.example.presentation.molecules

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.presentation.Theme.MyUiTheme

@Composable
fun Heading(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier,
        text = text,
        style = MyUiTheme.typography.H2
    )
}