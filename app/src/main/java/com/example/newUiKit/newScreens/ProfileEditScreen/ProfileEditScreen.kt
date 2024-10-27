package com.example.newUiKit.newScreens.ProfileEditScreen


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.newUiKit.Theme.MyUiTheme
import com.example.newUiKit.inputFields.IconAndTextPlaceholder
import com.example.newUiKit.inputFields.SimplePlaceholder
import com.example.newUiKit.inputFields.TextInputView
import com.example.newUiKit.molecules.Heading
import com.example.newUiKit.molecules.TopBar
import com.example.newUiKit.navigation.Screens
import com.example.newUiKit.newScreens.ProfileEditScreen.components.BigTextFieldView
import com.example.newUiKit.newScreens.ProfileEditScreen.components.TagsListInsideEditProfile
import com.example.newUiKit.newScreens.ProfileEditScreen.components.TextAndSwitchItem
import com.example.wbtechnoschoollesson2.R

@Composable
fun ProfileEditScreen(navController: NavController) {
    val tags = listOf("Разработка", "Дизайн", "Продакт менеджер", "Бэкенд")
    var isSwitchChecked1 by remember { mutableStateOf(true) }
    var isSwitchChecked2 by remember { mutableStateOf(true) }
    var isSwitchChecked3 by remember { mutableStateOf(true) }
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),

        ) {
        item {
            Box {
                Image(
                    painter = painterResource(id = R.drawable.test_image_4),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(374.dp)
                )
                TopBar(
                    title = "",
                    navigationIcon = {
                        IconButton(onClick = {
                            navController.navigate(Screens.ProfileInsideScreen) {
                                launchSingleTop = true
                            }
                        }
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.close),
                                contentDescription = "Back",
                                modifier = Modifier.size(24.dp),
                                tint = MyUiTheme.colors.secondaryColor
                            )
                        }
                    },
                    actions = {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                painter = painterResource(id = R.drawable.check_ic),
                                contentDescription = "",
                                modifier = Modifier.size(24.dp),
                                tint = MyUiTheme.colors.brandDefault,
                            )
                        }

                    },
                )
            }

        }
        item {
            Column(
                modifier = Modifier.padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Spacer(modifier = Modifier.height(40.dp))
                TextInputView(onNameChange = {})
                TextInputView(
                    onNameChange = {},
                    placeholderContent = { SimplePlaceholder(placeholderText = "+7 000 000-00-00") })
                TextInputView(
                    onNameChange = {},
                    placeholderContent = { SimplePlaceholder(placeholderText = "Город") })
                BigTextFieldView(onNameChange = {})
            }
        }
        item {
            Spacer(modifier = Modifier.height(40.dp))
            Heading(text = "Интересы", modifier = Modifier.padding(horizontal = 16.dp))
            Spacer(modifier = Modifier.height(10.dp))
            TagsListInsideEditProfile(tags = tags, navController = navController)
        }
        item {
            Spacer(modifier = Modifier.height(40.dp))
            Column(
                modifier = Modifier.padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Heading(
                    text = "Социальные сети",
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
                TextInputView(onNameChange = {}, placeholderContent = {
                    IconAndTextPlaceholder(
                        iconRes = R.drawable.habr_icon,
                        placeholderText = "Хабр"
                    )
                }
                )
                TextInputView(onNameChange = {}, placeholderContent = {
                    IconAndTextPlaceholder(
                        iconRes = R.drawable.telegram_icon,
                        placeholderText = "Телеграм"
                    )
                }
                )
            }


        }
        item {
            Spacer(modifier = Modifier.height(40.dp))
            TextAndSwitchItem(
                text = "Показывать мои сообщества",
                checked = isSwitchChecked1,
                onCheckedChange = { isSwitchChecked1 = it })
            Spacer(modifier = Modifier.height(16.dp))
            TextAndSwitchItem(
                text = "Показывать мои встречи",
                checked = isSwitchChecked2,
                onCheckedChange = { isSwitchChecked2 = it })
            Spacer(modifier = Modifier.height(32.dp))
            TextAndSwitchItem(
                text = "Включить уведомления",
                checked = isSwitchChecked3,
                onCheckedChange = { isSwitchChecked3 = it })

        }
        item {
            Spacer(modifier = Modifier.height(40.dp))
            Box(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Удалить профиль",
                    style = MyUiTheme.typography.primary,
                    color = MyUiTheme.colors.accentDanger,
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 28.dp)
                        .clickable {
                            navController.navigate(Screens.ProfileDeleteScreen) {
                                launchSingleTop = true
                            }
                        }
                )
            }
        }
    }

}
