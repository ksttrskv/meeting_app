package com.example.wbtechnoschoollesson2.organism


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wbtechnoschoollesson2.R
import com.example.wbtechnoschoollesson2.atoms.theme.UiTheme
import com.example.wbtechnoschoollesson2.atoms.theme.WBTechnoschoolLesson2Theme



@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun TopBar1(title: String, onAddClick: () -> Unit) {
    TopAppBar(
            title = {
                Text(
                    text = title,
                    fontSize = 24.sp,
                    color = Color.Black,
                    style = UiTheme.typography.subheading1
                )
            },
            actions = {
                IconButton(onClick = { }) {
                    Icon(
                        painter = painterResource(id = R.drawable.add_plus),
                        contentDescription = "Добавить",
                        tint = Color.Black,
                        modifier = Modifier.size(24.dp)
                    )
                }
            },
            colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = Color.Transparent
            )
        )
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun TopBar2(title: String, onAddClick: () -> Unit) {
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
            IconButton(onClick = {  }) {
                Icon(
                    painter = painterResource(id = R.drawable.back_icon),
                    contentDescription = "Добавить",
                    tint = Color.Black,
                    modifier = Modifier.size(24.dp)
                )
            }
        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = Color.Transparent
        )
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewTopBar() {
    WBTechnoschoolLesson2Theme {
        Column {

            TopBar2(title = "Мои встречи") {

            }
        }

    }
}