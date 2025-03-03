package com.example.presentation.Screens.AppointmentScreens.AppointmentFinalScreen

import androidx.compose.foundation.Image
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
import androidx.navigation.compose.rememberNavController
import com.example.presentation.Theme.MyMeetingAppTheme
import com.example.presentation.Theme.MyUiTheme
import com.example.presentation.Theme.multiColorLinearGradient
import com.example.presentation.navigation.Screens
import com.example.wbtechnoschoollesson2.R
import com.example.wbtechnoschoollesson2.atoms.buttons.CustomButton

@Composable
fun AppointmentFinalScreen(navController: NavController) {

    var phone by remember { mutableStateOf("") }
    val isPhoneFilled = phone.isNotEmpty()

    Box(
        modifier = Modifier
//            .padding(top = 48.dp)
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.make_an_appointment_background),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

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
                    text = "Вы записались на встречу",
                    style = MyUiTheme.typography.Huge,
                    color = MyUiTheme.colors.brandWhite,
                    modifier = Modifier.padding(top = 72.dp)

                )
            }
            Spacer(modifier = Modifier.height(14.dp))
            Text(
                text = "Супертестировщики \n12 августа \nНевский проспект, 11 ",
                style = MyUiTheme.typography.regular,
                color = MyUiTheme.colors.brandWhite
            )
            Spacer(modifier = Modifier.height(24.dp))
        }
        Text(
            text = "Мои встречи",
            style = MyUiTheme.typography.primary,
            color = MyUiTheme.colors.brandDefault,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 108.dp)
                .clickable { }
        )
        CustomButton(
            content = {
                Text(
                    text = "Найти новые встречи",
                    style = MyUiTheme.typography.H3
                )
            },
            textColor = Color.White,
            enabledGradient = multiColorLinearGradient(),
            disabledColor = Color.Gray,
            enabled = true,
            onClick = {
                navController.navigate(Screens.MainScreen) {
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

@Preview(showBackground = true)
@Composable
fun PreviewAppointmentScreens() {
    MyMeetingAppTheme {
        val navController = rememberNavController()
        AppointmentFinalScreen(navController = navController)
    }
}