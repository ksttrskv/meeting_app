package com.example.newUiKit.newScreens.EventDetailScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.newUiKit.navigation.Screens
import com.example.newUiKit.newTheme.MyUiTheme
import com.example.newUiKit.newTheme.multiColorLinearGradient
import com.example.newUiKit.newTheme.multiColorLinearGradientWhite
import com.example.wbtechnoschoollesson2.R
import com.example.wbtechnoschoollesson2.atoms.buttons.NewCustomButton

@Composable
fun PopupButton(
    navController: NavController,
    isRegistered: Boolean,
    onRegistrationChange: () -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent),
        shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
        color = Color.White,
        shadowElevation = 16.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            if (!isRegistered) {
                Text(
                    text = "Всего 30 мест. Если передумаете — отпишитесь",
                    style = MyUiTheme.typography.Secondary,
                    color = MyUiTheme.colors.newBrandDefault,
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .align(Alignment.CenterHorizontally)
                )
            } else {
                Text(
                    text = "✓ Вы пойдёте",
                    style = MyUiTheme.typography.primary,
                    color = MyUiTheme.colors.accentSuccess,
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .align(Alignment.CenterHorizontally)
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            NewCustomButton(
                content = {
                    Text(
                        text = if (isRegistered) "Не смогу пойти" else stringResource(R.string.sign_up_for_a_meeting),
                        style = MyUiTheme.typography.primary
                    )
                },
                textColor = if (isRegistered) MyUiTheme.colors.newBrandDefault else Color.White,
                enabledGradient = if (isRegistered) multiColorLinearGradientWhite() else multiColorLinearGradient(),
                disabledColor = Color.Gray,
                enabled = true,
                onClick = {
                    onRegistrationChange()
                    navController.navigate(Screens.AppointmentNameInputScreen) {
                        launchSingleTop = true
                    }
                }
            )
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}