package com.example.newUiKit.NewMolecules

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.newUiKit.newTheme.MyUiTheme

@Composable
fun NewHeading(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier,
        text = text,
        style = MyUiTheme.typography.H2
    )
}