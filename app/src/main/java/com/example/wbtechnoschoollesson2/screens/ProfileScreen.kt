@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.wbtechnoschoollesson2.screens

import com.example.wbtechnoschoollesson2.Molecules.ProfileAvatar
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.wbtechnoschoollesson2.R
import com.example.wbtechnoschoollesson2.atoms.theme.UiTheme
import com.example.wbtechnoschoollesson2.atoms.theme.WBTechnoschoolLesson2Theme
import com.example.wbtechnoschoollesson2.navigation.BottomNavigation
import com.example.wbtechnoschoollesson2.navigation.TopBar3
import com.example.wbtechnoschoollesson2.screens.ViewModels.ProfileViewModel
import com.example.wbtechnoschoollesson2.uiKitScreen.ButtonIconLine
import com.example.wbtechnoschoollesson2.uiKitScreen.TypographyLine1
import org.koin.androidx.compose.koinViewModel


@Composable
fun ProfileScreen(navController: NavController, viewModel: ProfileViewModel = koinViewModel()) {
    val userName by viewModel.userName.collectAsState()
    val userPhone by viewModel.userPhone.collectAsState()
    Scaffold(
        topBar = {
            TopBar3(
                title = "Профиль",
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(
                            painter = painterResource(id = R.drawable.back_icon),
                            contentDescription = "Back",
                            modifier = Modifier.size(24.dp)
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { }) {
                        Icon(
                            painter = painterResource(id = R.drawable.icon_edit),
                            contentDescription = "Редактировать",
                            tint = Color.Black,
                            modifier = Modifier.size(18.dp)
                        )
                    }
                }
            )
        },
        bottomBar = {
            BottomNavigation(navController = navController)
        },
        containerColor = Color.White

    ) { contentPadding ->
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding)
                .padding(top = 46.dp)
                .background(Color.White)
        ) {
            item {
                Spacer(modifier = Modifier.size(46.dp))
                ProfileAvatar(
                    avatarResId = R.drawable.avatarpw1,
                    isEditing = false,
                    size = 100.dp
                )
            }
            item {
                Spacer(modifier = Modifier.size(20.dp))
                TypographyLine1(
                    title = userName,
                    subTitle = userPhone
                )
            }
            item {
                Spacer(modifier = Modifier.size(20.dp))
                ButtonIconLine(color = UiTheme.colors.brandColorDefault, enabled = true)
            }

        }

    }
}
@Preview(showBackground = true)
@Composable
fun PreviewProfileAvatar() {
    WBTechnoschoolLesson2Theme {
        val navController = rememberNavController()
        ProfileScreen(navController=navController)
    }
}








