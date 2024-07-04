package com.example.wbtechnoschoollesson2.organism


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.wbtechnoschoollesson2.atoms.theme.UiTheme
import com.example.wbtechnoschoollesson2.atoms.theme.WBTechnoschoolLesson2Theme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar3(
    title: String,
    onAddClick: (() -> Unit)? = null,
    navigationIcon: (@Composable () -> Unit)? = null,
    actions: @Composable RowScope.() -> Unit = {}
) {
    TopAppBar(
        title = {
            Text(
                text = title,
                fontSize = 24.sp,
                color = Color.Black,
                style = UiTheme.typography.subheading1,
            )
        },
        navigationIcon = {
            navigationIcon?.invoke()
        },
        actions = {
            onAddClick?.let {
                IconButton(onClick = it) {
                    Icon(Icons.Default.Add, contentDescription = "Add")
                }
            }
            actions()
        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = Color.Transparent
        )
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewTopBar() {
    WBTechnoschoolLesson2Theme {
        Column {

            TopBar3(title = "Мои встречи") {

            }
        }

    }
}