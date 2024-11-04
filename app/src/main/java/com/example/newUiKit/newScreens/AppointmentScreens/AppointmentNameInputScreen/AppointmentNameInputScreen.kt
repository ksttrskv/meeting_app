package com.example.newUiKit.newScreens.AppointmentScreens.AppointmentNameInputScreen

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
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.newUiKit.Theme.MyUiTheme
import com.example.newUiKit.Theme.multiColorLinearGradient
import com.example.newUiKit.inputFields.TextInputView
import com.example.newUiKit.navigation.Screens
import com.example.wbtechnoschoollesson2.R
import com.example.wbtechnoschoollesson2.atoms.buttons.CustomButton
import org.koin.androidx.compose.getViewModel

@Composable
fun AppointmentNameInputScreen(
    navController: NavController,
//    eventTitle: String,
//    eventDate:String,
//    eventLocation:String,
//    eventImageRes: String,
    viewModel: AppointmentNameInputViewModel = getViewModel()
) {
//    val eventTitle by viewModel.eventTitle.observeAsState("")
//    val eventDate by viewModel.eventDate.observeAsState("")
//    val eventLocation by viewModel.eventLocation.observeAsState("")
    val name by viewModel.name.observeAsState("")
    val isButtonEnabled by viewModel.isButtonEnabled.observeAsState(false)

    Box(
        modifier = Modifier
            .padding(top = 48.dp)
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween // Размещаем элементы по краям
            ) {
                Text(
                    text = stringResource(R.string.entrance_and_recording_to_the_meeting),
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
//                text = "$eventTitle  · $eventDate · $eventLocation ",
                text = "Cergdfg  · 12 123 · spb nevskiy ",
                style = MyUiTheme.typography.regular
            )
            Spacer(modifier = Modifier.height(24.dp))
            TextInputView(name = name, onNameChange = { viewModel.onNameChange(it) })
        }
        CustomButton(
            content = {
                Text(
                    text = "Продолжить",
                    style = MyUiTheme.typography.H3
                )
            },
            textColor = Color.White,
            enabledGradient = multiColorLinearGradient(),
            disabledColor = MyUiTheme.colors.offWhite,
            enabled = isButtonEnabled,
            onClick = {
                navController.navigate(Screens.AppointmentPhoneInputScreen) {
                    launchSingleTop = true
                }
            },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 28.dp)
                .height(56.dp)
        )
    }
}
