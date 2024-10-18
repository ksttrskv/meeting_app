package com.example.newUiKit.newScreens.MembersScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.newUiKit.NewMolecules.PersonCard
import com.example.newUiKit.navigation.Screens
import com.example.wbtechnoschoollesson2.R

@Composable
fun MembersColumnRow(users: List<UserData>, navController: NavController) {

    val users = listOf(
        UserData(
            title = "Мария",
            painter = R.drawable.test_image_3,
            tag = "Developer"
        ),

        UserData(
            title = "Андрей",
            painter = R.drawable.test_image_2,
            tag = "Developer"
        ),

        UserData(
            title = "Ирина",
            painter = R.drawable.comp_img,
            tag = "Design"
        ),
        UserData(
            title = "Николай",
            painter = R.drawable.user_avatar,
            tag = "Design"
        ),

        UserData(
            title = "Егор",
            painter = R.drawable.user_avatar,
            tag = "Тестирование"
        ),

        UserData(
            title = "Саша",
            painter = R.drawable.user_avatar,
            tag = "Developer"
        ),
        UserData(
            title = "Ксюша",
            painter = R.drawable.user_avatar,
            tag = "Developer"
        ),

        UserData(
            title = "Ашот",
            painter = R.drawable.user_avatar,
            tag = "Backend"
        ),

        UserData(
            title = "Илья",
            painter = R.drawable.user_avatar,
            tag = "Design"
        ),

        UserData(
            title = "Егор",
            painter = R.drawable.user_avatar,
            tag = "Design"
        ),

        UserData(
            title = "Саша",
            painter = R.drawable.user_avatar,
            tag = "Developer"
        ),
        UserData(
            title = "Ксюша",
            painter = R.drawable.test_image_4,
            tag = "Design"
        ),

        UserData(
            title = "Ашот",
            painter = R.drawable.eventcard_testimage,
            tag = "Backend"
        ),


        )
    Column(modifier = Modifier.padding(16.dp)) {
        for (i in users.indices step 3) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween // Чтобы карточки равномерно располагались по ширине
            ) {
                for (j in 0 until 3) {
                    if (i + j < users.size) { // Проверяем, чтобы не выйти за пределы списка
                        PersonCard(
                            title = users[i + j].title,
                            painter = painterResource(users[i + j].painter),
                            tag = users[i + j].tag,
                            modifier = Modifier
//                                .weight(1f)
                                .clickable {
                                    navController.navigate(
                                        "${Screens.ProfileOutsideScreen}/${users[i + j].title}/${users[i + j].painter}"
                                    ) {
                                        launchSingleTop = true
                                    }
                                },
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(25.dp)) // Отступ между рядами
        }
    }
}

data class UserData(
    val title: String,
    val painter: Int,
    val tag: String
)

