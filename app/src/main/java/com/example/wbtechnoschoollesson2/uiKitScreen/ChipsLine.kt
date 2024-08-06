package com.example.wbtechnoschoollesson2.uiKitScreen

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.wbtechnoschoollesson2.atoms.chips.CustomFilterChip

@Composable
fun ChipsLine() {
    Row(
        modifier = Modifier
            .height(28.dp)
            .padding(end = 4.dp),
    ) {
        CustomFilterChip(text = "Python")
        CustomFilterChip(text = "Junior")
        CustomFilterChip(text = "Moscow")
    }
}