package com.example.newUiKit.newScreens.ProfileEditScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.newUiKit.SwitchItem
import com.example.newUiKit.newTheme.MyUiTheme

@Composable
fun TextAndSwitchItem(text: String, checked: Boolean) {
    var isSwitchChecked by remember { mutableStateOf(true) }
    Row(horizontalArrangement = Arrangement.SpaceBetween) {
        Text(
            text = text,
            style = MyUiTheme.typography.primary,
            color = MyUiTheme.colors.newBrandDefault
        )
        SwitchItem(checked = checked, onCheckedChange = { isSwitchChecked = it })
    }
}