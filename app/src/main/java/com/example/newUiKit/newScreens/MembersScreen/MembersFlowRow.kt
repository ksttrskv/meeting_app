package com.example.newUiKit.newScreens.MembersScreen

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.newUiKit.NewMolecules.PersonCard
import com.example.wbtechnoschoollesson2.R
import com.google.accompanist.flowlayout.FlowRow

@Composable
fun MembersFlowRow(users: List<UserData>, onCardClick: (UserData) -> Unit) {

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

        UserData(
            title = "Илья",
            painter = R.drawable.test_avatar_user,
            tag = "Тестирование"
        ),


        )


    FlowRow(
        modifier = Modifier.padding(16.dp),
        mainAxisSpacing = 12.dp, // Расстояние между карточками по главной оси
        crossAxisSpacing = 25.dp // Расстояние между строками
    ) {
        for (user in users) {
            PersonCard(
                title = user.title,
                painter = painterResource(id = user.painter),
                tag = user.tag
            )
        }
    }
}

data class UserData(
    val title: String,
    val painter: Int,
    val tag: String
)