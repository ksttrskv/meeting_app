package com.example.wbtechnoschoollesson2.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.wbtechnoschoollesson2.Molecules.ProfileAvatar
import com.example.wbtechnoschoollesson2.R
import com.example.wbtechnoschoollesson2.TextFields.TextFieldNameView
import com.example.wbtechnoschoollesson2.TextFields.TextFieldSurnameView
import com.example.wbtechnoschoollesson2.atoms.buttons.WbSolidButton
import com.example.wbtechnoschoollesson2.atoms.theme.UiTheme
import com.example.wbtechnoschoollesson2.navigation.TopBar3
import com.example.wbtechnoschoollesson2.screens.ViewModels.ProfileCreateViewModel
import com.example.wbtechnoschoollesson2.screens.ViewModels.ProfileViewModel
import org.koin.androidx.compose.koinViewModel


@Composable
fun ProfileCreateScreen(navController: NavController, profileViewModel: ProfileViewModel = koinViewModel(), viewModel: ProfileCreateViewModel = koinViewModel()) {
//    var query by remember { mutableStateOf(TextFieldValue("")) }
    val name by viewModel.name.collectAsState()
    val surname by viewModel.surname.collectAsState()
    val isNameFilled = name.isNotEmpty()
    Scaffold(
        topBar = {
            TopBar3(
                title = "",
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(
                            painter = painterResource(id = R.drawable.back_icon),
                            contentDescription = "Back",
                            modifier = Modifier.size(24.dp)
                        )
                    }
                },
            )
        },
        bottomBar = { },
        containerColor = Color.White

    ) { contentPadding ->
        Box(
            modifier = Modifier
                .padding(contentPadding)
                .padding(start = 24.dp, end = 24.dp)
                .fillMaxSize()
                .background(Color.White),
            contentAlignment = Alignment.TopStart
        ) {
            LazyColumn(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 168.dp)
                    .background(Color.White)
            ) {
                item {
                    ProfileAvatar(
                        avatarResId = R.drawable.avatarpw1,
                        isEditing = true,
                        size = 56.dp
                    )
                    Spacer(modifier = Modifier.size(32.dp))
                }
                item {
                    TextFieldNameView(
                        name = name,
                        onNameChange = { newName -> viewModel.onNameChanged(newName) }
                    )

                    Spacer(modifier = Modifier.size(12.dp))
                }
                item {
                    TextFieldSurnameView(
                        surname = surname,
                        onSurnameChange = { newSurname -> viewModel.onSurnameChanged(newSurname) }
                    )


                    Spacer(modifier = Modifier.size(56.dp))
                }
                item {
                    WbSolidButton(
                        modifier = Modifier.fillMaxWidth(),
                        content = {
                            Text(
                                text = stringResource(R.string.save_button),
                                style = UiTheme.typography.subheading2,
                                color = UiTheme.colors.neutralOffWhite
                            )
                        },
                        btnColor = UiTheme.colors.brandColorDefault,
                        textColor = UiTheme.colors.neutralOffWhite,
                        onClick = {
                            viewModel.saveUserProfile()
                            profileViewModel.updateUserProfile(name, surname)
                            navController.navigate(Screens.AllMeetings) {
                                popUpTo(Screens.ProfileCreate) { inclusive = true }
                            }
                             },
                        enabled = isNameFilled
                    )
                }
            }
        }
    }
}

