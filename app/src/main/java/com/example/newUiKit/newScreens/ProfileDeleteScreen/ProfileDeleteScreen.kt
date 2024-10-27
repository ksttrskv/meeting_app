package com.example.newUiKit.newScreens.ProfileDeleteScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.newUiKit.Theme.MyUiTheme
import com.example.newUiKit.Theme.multiColorLinearGradient
import com.example.newUiKit.Theme.multiColorLinearGradientWhite
import com.example.newUiKit.navigation.Screens
import com.example.wbtechnoschoollesson2.R
import com.example.wbtechnoschoollesson2.atoms.buttons.CustomButton

@Composable
fun ProfileDeleteScreen(navController: NavController) {

    Box(
        modifier = Modifier
            .padding(top = 48.dp)
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween // Размещаем элементы по краям
            ) {
                Text(
                    text = "Точно \nудалить \nпрофиль?",
                    style = MyUiTheme.typography.Huge
                )
                Icon(
                    painter = painterResource(id = R.drawable.close),
                    contentDescription = "Close page",
                    tint = MyUiTheme.colors.newGray,
                    modifier = Modifier.clickable {
                        navController.navigate(Screens.ProfileInsideScreen) {
                            launchSingleTop = true
                        }
                    }
                )
            }
            Spacer(modifier = Modifier.height(14.dp))
            Text(
                text = "Не надо...... Мы крутые\n" +
                        "\nМы удалим профиль, но не сразу. У вас будет 30 дней чтобы зайти и обратно всё вернуть ",
                style = MyUiTheme.typography.regular
            )

        }

        CustomButton(
            content = {
                Text(
                    text = "Удалить",
                    style = MyUiTheme.typography.H3
                )
            },
            textColor = MyUiTheme.colors.brandDefault,
            enabledGradient = multiColorLinearGradientWhite(),
            disabledColor = MyUiTheme.colors.offWhite,
            enabled = true,
            onClick = {},
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 100.dp)
                .padding(horizontal = 16.dp)
                .height(56.dp)
        )
        CustomButton(
            content = {
                Text(
                    text = "Не надо",
                    style = MyUiTheme.typography.H3
                )
            },
            textColor = MyUiTheme.colors.brandWhite,
            enabledGradient = multiColorLinearGradient(),
            disabledColor = MyUiTheme.colors.offWhite,
            enabled = true,
            onClick = {
                navController.navigate(Screens.ProfileEditScreen) {
                    launchSingleTop = true
                }
            },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 28.dp)
                .padding(horizontal = 16.dp)
                .height(56.dp)
        )
    }
}