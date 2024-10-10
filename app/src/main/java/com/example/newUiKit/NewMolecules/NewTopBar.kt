package com.example.newUiKit.NewMolecules

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.newUiKit.newTheme.MyUiTheme
import com.example.wbtechnoschoollesson2.atoms.theme.WBTechnoschoolLesson2Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewTopBar(
    title: String,
    onAddClick: (() -> Unit)? = null,
    navigationIcon: (@Composable () -> Unit)? = null,
    actions: @Composable RowScope.() -> Unit = {}
) {
    TopAppBar(
        title = {
            Text(
                text = title,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontSize = 24.sp,
                color = Color.Black,
                style = MyUiTheme.typography.primary,
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

            com.example.wbtechnoschoollesson2.navigation.TopBar3(title = "Мои встречи") {

            }
        }

    }
}