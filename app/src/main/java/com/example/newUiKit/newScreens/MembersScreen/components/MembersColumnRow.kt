package com.example.newUiKit.newScreens.MembersScreen.components

import android.net.Uri
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.models.UserData
import com.example.newUiKit.NewMolecules.PersonCard
import com.example.newUiKit.navigation.Screens

const val MAX_USERS_IN_ROW = 3
@Composable
fun MembersColumnRow(users: List<UserData>, navController: NavController) {

    Column(modifier = Modifier.padding(16.dp)) {
        for (i in users.indices step 3) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween // Чтобы карточки равномерно располагались по ширине
            ) {
                for (j in 0 until MAX_USERS_IN_ROW) {
                    if (i + j < users.size) { // Проверяем, чтобы не выйти за пределы списка
                        PersonCard(
                            title = users[i + j].title,
                            imageUrl = users[i + j].painter,
                            tag = users[i + j].tag,
                            modifier = Modifier
                                .weight(1f)
                                .clickable {
                                    navController.navigate(
                                        "${Screens.ProfileOutsideScreen}/${Uri.encode(users[i + j].title)}/${
                                            Uri.encode(
                                                users[i + j].painter
                                            )
                                        }"
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



