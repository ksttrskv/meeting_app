package com.example.wbtechnoschoollesson2.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.wbtechnoschoollesson2.Molecules.ProfileAvatar
import com.example.wbtechnoschoollesson2.R
import com.example.wbtechnoschoollesson2.TextFields.TextFieldNameView
import com.example.wbtechnoschoollesson2.TextFields.TextFieldSurnameView
import com.example.wbtechnoschoollesson2.atoms.buttons.WbSolidButton
import com.example.wbtechnoschoollesson2.atoms.theme.UiTheme
import com.example.wbtechnoschoollesson2.atoms.theme.WBTechnoschoolLesson2Theme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileCreateScreen(navController: NavController) {
    var query by remember { mutableStateOf(TextFieldValue("")) }

    val isNameFilled = query.text.isNotEmpty()

    Box(
        modifier = Modifier
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
                ProfileAvatar(avatarResId = R.drawable.avatarpw1, isEditing = true, size = 56.dp)
                Spacer(modifier = Modifier.size(32.dp))
            }
            item {
                TextFieldNameView(
                    query = query,
                    onQueryChange = { newQuery -> query = newQuery },
                )
                Spacer(modifier = Modifier.size(12.dp))
            }
            item {
                TextFieldSurnameView()
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
                    onClick = { navController.navigate("all_meetings") },
                    enabled = isNameFilled
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ProfileCreateScreenPreview() {
    WBTechnoschoolLesson2Theme {
        val navContoller = rememberNavController()
        ProfileCreateScreen(navController = navContoller)

    }
}
