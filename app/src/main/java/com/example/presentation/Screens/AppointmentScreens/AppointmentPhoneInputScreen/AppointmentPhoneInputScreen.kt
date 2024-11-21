package com.example.presentation.Screens.AppointmentScreens.AppointmentPhoneInputScreen

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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.presentation.Theme.MyUiTheme
import com.example.presentation.Theme.multiColorLinearGradient
import com.example.presentation.inputFields.PhoneInputField.PhoneInput
import com.example.presentation.navigation.Screens
import com.example.wbtechnoschoollesson2.R
import com.example.wbtechnoschoollesson2.atoms.buttons.CustomButton
import org.koin.androidx.compose.getViewModel

@Composable
fun AppointmentPhoneInputScreen(
    navController: NavController,
    viewModel: AppointmentPhoneInputViewModel = getViewModel()
) {

    val isButtonEnabled by viewModel.isButtonEnabled.collectAsState()

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
                    text = stringResource(R.string.enter_to_event),
                    style = MyUiTheme.typography.Huge
                )
                Icon(
                    painter = painterResource(id = R.drawable.close),
                    contentDescription = "Close page",
                    tint = MyUiTheme.colors.newGray,
                    modifier = Modifier.clickable { navController.navigateUp() }
                )
            }
            Spacer(modifier = Modifier.height(14.dp))
            Text(
                text = "Супертестировщики · 12 августа · Невский проспект, 11 ",
                style = MyUiTheme.typography.regular
            )
            Spacer(modifier = Modifier.height(24.dp))
            PhoneInput { phone ->
                viewModel.updatePhoneNumber(phone)
            }
        }
        CustomButton(
            content = {
                Text(
                    text = stringResource(R.string.get_code),
                    style = MyUiTheme.typography.H3
                )
            },
            textColor = Color.White,
            enabledGradient = multiColorLinearGradient(),
            disabledColor = MyUiTheme.colors.offWhite,
            enabled = true,
            onClick = {
                navController.navigate(Screens.AppointmentCodeInputScreen) {
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

