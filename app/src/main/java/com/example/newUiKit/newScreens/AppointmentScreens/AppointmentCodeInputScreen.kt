package com.example.newUiKit.newScreens.AppointmentScreens

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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.newUiKit.navigation.Screens
import com.example.newUiKit.newInputFields.NewCodeInputView
import com.example.newUiKit.newTheme.MyUiTheme
import com.example.newUiKit.newTheme.multiColorLinearGradient
import com.example.wbtechnoschoollesson2.R
import com.example.wbtechnoschoollesson2.atoms.buttons.NewCustomButton

@Composable
fun AppointmentCodeInputScreen(navController: NavController) {
    var code by remember { mutableStateOf("") }
    val isCodeFilled = code.isNotEmpty()
    Box(
        modifier = Modifier
            .padding(top = 48.dp)
            .fillMaxSize()
//            .background(Color.White)

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
                    text = "Вход \nи запись \nна встречу",
                    style = MyUiTheme.typography.Huge
                )
                Icon(
                    painter = painterResource(id = R.drawable.close),
                    contentDescription = "Close page",
                    tint = MyUiTheme.colors.newGray,
                    modifier = Modifier.clickable {
                        navController.navigateUp()
                    }
                )
            }
            Spacer(modifier = Modifier.height(14.dp))
            Text(
                text = "Супертестировщики · 12 августа · Невский проспект, 11 ",
                style = MyUiTheme.typography.regular
            )
            Spacer(modifier = Modifier.height(24.dp))
            NewCodeInputView {

            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Отправили код на +7 999 999-99-99",
                style = MyUiTheme.typography.Secondary,
                color = MyUiTheme.colors.newSecondaryColor
            )
        }

        Text(
            text = "Получить новый код через 10",
            style = MyUiTheme.typography.primary,
            color = MyUiTheme.colors.newSecondaryColor,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 108.dp)
        )
        NewCustomButton(
            content = {
                Text(
                    text = "Отправить и подтвердить запись",
                    style = MyUiTheme.typography.H3
                )
            },
            textColor = MyUiTheme.colors.newBrandWhite,
            enabledGradient = multiColorLinearGradient(),
            disabledColor = MyUiTheme.colors.newOffWhite,
            enabled = true,
            onClick = {
                navController.navigate(Screens.AppointmentFinalScreen) {
                    launchSingleTop = true
                }
            },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 28.dp)
                .padding(horizontal = 16.dp)
        )
    }
}

//@Preview(showBackground = true)
//@Composable
//fun PreviewAppointmentScreen() {
//    WBTechnoschoolLesson2Theme {
//        AppointmentCodeInputScreen()
//    }
//}