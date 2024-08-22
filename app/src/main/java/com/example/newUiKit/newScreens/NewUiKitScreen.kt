package com.example.newUiKit.newScreens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.newUiKit.SwitchItem
import com.example.newUiKit.newButtons.NewSolidButton
import com.example.wbtechnoschoollesson2.atoms.buttons.NewOutlineButton
import com.example.wbtechnoschoollesson2.uiKitScreen.Heading
import kotlinx.coroutines.delay


@Composable
fun NewUiKitScreen(modifier: Modifier = Modifier, navController: NavController) {
    var isLoading by remember { mutableStateOf(false) }
    var isSwitchChecked by remember { mutableStateOf(true) }

    // `LaunchedEffect` находится на верхнем уровне
    LaunchedEffect(isLoading) {
        if (isLoading) {
            delay(2000) // Задержка в 2 секунды
            isLoading = false
        }
    }

    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(56.dp)
    ) {
        item {
            Column(
                verticalArrangement = Arrangement.spacedBy(56.dp)
            ) {
                Heading(text = "Buttons")
                NewOutlineButton(
                    content = { Text(text = "Оплатить") },
                    textColor = Color.White,
                    onClick = { /*TODO*/ },
                    enabled = true
                )
            }
        }
        item {
            NewSolidButton(
                isLoading = isLoading,
                content = { Text(text = "Оплатить") },
                textColor = Color.White,
                enabled = true,
                onClick = {
                    isLoading = true
                }
            )
        }
        item {
            SwitchItem(
                checked = isSwitchChecked,
                onCheckedChange = { isSwitchChecked = it }
            )
        }
    }
}
