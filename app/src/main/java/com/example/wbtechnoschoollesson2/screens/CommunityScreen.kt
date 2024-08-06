package com.example.wbtechnoschoollesson2.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.wbtechnoschoollesson2.Molecules.CommunityCard
import com.example.wbtechnoschoollesson2.atoms.theme.UiTheme
import com.example.wbtechnoschoollesson2.navigation.BottomNavigation
import com.example.wbtechnoschoollesson2.navigation.TopBar3
import com.example.wbtechnoschoollesson2.screens.ViewModels.CommunityViewModel
import com.example.wbtechnoschoollesson2.uiKitScreen.SearchView
import org.koin.androidx.compose.koinViewModel


@Composable
fun CommunityScreen(navController: NavController, viewModel: CommunityViewModel = koinViewModel()) {
    val communities by viewModel.communities.collectAsState(initial = emptyList())
    Scaffold(
        topBar = {
            TopBar3(
                title = "Сообщества",
            )
        },
        bottomBar = {
            BottomNavigation(navController = navController)
        },
        containerColor = Color.White

    ) { contentPadding ->
        Box(
            modifier = Modifier
                .padding(contentPadding)
                .fillMaxSize()
                .background(Color.White)
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 24.dp, end = 24.dp, top = 16.dp)
                    .background(Color.White)
            ) {

                item {
                    SearchView()
                    Spacer(modifier = Modifier.height(16.dp))
                }



                items(communities) { community ->
                    CommunityCard(
                        imageUrl = community.imageUrl,
                        title = community.title,
                        subtitle = community.subtitle,
                        onClick = {
                            navController.navigate("${Screens.CommunityDetail}/${community.title}") {
                                launchSingleTop = true
                            }
                        }
                    )

                    HorizontalDivider(thickness = 1.dp, color = UiTheme.colors.neutralLine)
                    Spacer(modifier = Modifier.height(16.dp))

                }
            }
        }
    }
}
