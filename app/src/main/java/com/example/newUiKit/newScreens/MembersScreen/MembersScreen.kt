package com.example.newUiKit.newScreens.MembersScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.newUiKit.NewMolecules.NewTopBar
import com.example.newUiKit.newScreens.MembersScreen.components.MembersColumnRow
import com.example.newUiKit.newTheme.MyMeetingAppTheme
import com.example.newUiKit.newTheme.MyUiTheme
import com.example.wbtechnoschoollesson2.R
import org.koin.androidx.compose.getViewModel

@Composable
fun MembersScreen(navController: NavController, viewModel: MembersViewModel = getViewModel()) {
    val users by viewModel.users.observeAsState(emptyList())

    LaunchedEffect(Unit) {
        viewModel.loadUsers()
    }

    Scaffold(
        topBar = {
            NewTopBar(
                title = "Пойдут на встречу",
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(
                            painter = painterResource(id = R.drawable.back),
                            contentDescription = "Back",
                            modifier = Modifier.size(24.dp),
                            tint = MyUiTheme.colors.newBrandDefault
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.more_horizontal),
                            contentDescription = "",
                            tint = Color.White
                        )
                    }

                }
            )
        },
        containerColor = Color.White
    ) { contentPadding ->
        Box {
            LazyColumn(
                modifier = Modifier
                    .padding(contentPadding)
                    .padding(horizontal = 10.dp)
                    .background(Color.White),
                verticalArrangement = Arrangement.spacedBy(30.dp)
            ) {
                item { MembersColumnRow(users = users, navController = navController) }

            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun PersonCardFlowRowPreview() {
    MyMeetingAppTheme {
        val navController = rememberNavController()
        MembersScreen(navController = navController)
    }
}