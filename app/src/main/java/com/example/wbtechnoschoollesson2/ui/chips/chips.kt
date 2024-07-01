package com.example.wbtechnoschoollesson2.ui.chips

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.wbtechnoschoollesson2.ui.theme.UiTheme


@Composable
fun CustomFilterChip(text : String) {
    var selected by remember { mutableStateOf(false) }

    FilterChip(
        onClick = { },
        label = {
            Text(
                text = text,
                style = UiTheme.typography.metadata3)
        },
        shape = RoundedCornerShape(40.dp),
        selected = selected,
        leadingIcon = if (selected) {
            {
                Icon(
                    imageVector = Icons.Filled.Done,
                    contentDescription = "Done icon",
                    modifier = Modifier.size(FilterChipDefaults.IconSize)
                )
            }
        } else {
            null
        },
        colors = FilterChipDefaults.filterChipColors(
            containerColor = UiTheme.colors.brandColorBg,
            labelColor = UiTheme.colors.brandColorDark,
            selectedContainerColor = UiTheme.colors.brandColorBg,
            selectedLabelColor = UiTheme.colors.brandColorDark,
            selectedLeadingIconColor = UiTheme.colors.brandColorDark
        ),
        border = null
    )
}
