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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.newUiKit.NewMolecules.NewHeading
import com.example.newUiKit.NewMolecules.NewTopBar
import com.example.newUiKit.newInputFields.IconAndTextPlaceholder
import com.example.newUiKit.newInputFields.NewTextInputView
import com.example.newUiKit.newInputFields.SimplePlaceholder
import com.example.newUiKit.newTheme.MyMeetingAppTheme
import com.example.newUiKit.newTheme.MyUiTheme
import com.example.wbtechnoschoollesson2.R

@Composable
fun ProfileEditScreen(navController: NavController) {
    val tags = listOf("Разработка", "Дизайн", "Продакт менеджер", "Бэкенд")
    var isSwitchChecked by remember { mutableStateOf(true) }
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
                NewTopBar(
                    title = "",
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
                                painter = painterResource(id = R.drawable.edit_ic),
                                contentDescription = "",
                                tint = MyUiTheme.colors.newBrandDefault,
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
                NewTextInputView(onNameChange = {})
                NewTextInputView(
                    onNameChange = {},
                    placeholderContent = { SimplePlaceholder(placeholderText = "+7 000 000-00-00") })
                NewTextInputView(
                    onNameChange = {},
                    placeholderContent = { SimplePlaceholder(placeholderText = "Город") })
                BigTextFieldView(onNameChange = {})
            }
        }
        item {
            Spacer(modifier = Modifier.height(40.dp))
            NewHeading(text = "Интересы", modifier = Modifier.padding(horizontal = 16.dp))
            Spacer(modifier = Modifier.height(10.dp))
            TagsListInsideEditProfile(tags = tags, modifier = Modifier.padding(horizontal = 16.dp))
        }
        item {
            Spacer(modifier = Modifier.height(40.dp))
            Column(
                modifier = Modifier.padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                NewHeading(
                    text = "Социальные сети",
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
                NewTextInputView(onNameChange = {})
                NewTextInputView(onNameChange = {}, placeholderContent = {
                    IconAndTextPlaceholder(
                        iconRes = R.drawable.habr_icon,
                        placeholderText = "Хабр"
                    )
                }
                )
                NewTextInputView(onNameChange = {}, placeholderContent = {
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
            TextAndSwitchItem(text = "Показывать мои сообщества", checked = isSwitchChecked)
            Spacer(modifier = Modifier.height(16.dp))
            TextAndSwitchItem(text = "Показывать мои встречи", checked = isSwitchChecked)
            Spacer(modifier = Modifier.height(32.dp))
            TextAndSwitchItem(text = "Включить уведомления", checked = isSwitchChecked)

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
                        .clickable { }
                )
            }
        }
    }

}


@Preview(showBackground = true)
@Composable
fun PreviewProfileEditScreen() {
    MyMeetingAppTheme {
//        val navcontroller = rememberNavController()
//        ProfileEditScreen(navController = navcontroller)
        NewTextInputView(onNameChange = {}, placeholderContent = {
            IconAndTextPlaceholder(
                iconRes = R.drawable.habr_icon,
                placeholderText = "Хабр"
            )
        }
        )
    }
}