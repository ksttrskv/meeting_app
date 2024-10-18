package com.example.newUiKit.newScreens.ProfileEditScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.newUiKit.GradientSwitch
import com.example.newUiKit.newTheme.MyUiTheme

@Composable
fun TextAndSwitchItem(text: String, checked: Boolean, onCheckedChange: (Boolean) -> Unit) {
    var isSwitchChecked by remember { mutableStateOf(true) }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        Alignment.CenterVertically
    ) {
        Text(
            text = text,
            style = MyUiTheme.typography.primary,
            color = MyUiTheme.colors.newBrandDefault
        )
        GradientSwitch(checked = checked, onCheckedChange = onCheckedChange)
    }
}