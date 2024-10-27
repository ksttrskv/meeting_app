package com.example.newUiKit.molecules

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.newUiKit.Theme.MyUiTheme

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