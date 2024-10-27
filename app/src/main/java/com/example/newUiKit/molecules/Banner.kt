package com.example.newUiKit.molecules

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.newUiKit.Theme.MyUiTheme
import com.example.newUiKit.Theme.combinedGradient
import com.example.newUiKit.Theme.multiColorComplexGradient
import com.example.newUiKit.Theme.multiColorLinearGradientWhite
import com.example.newUiKit.buttons.SolidButton
import com.example.newUiKit.navigation.Screens
import com.example.wbtechnoschoollesson2.R

@Composable
fun Banner(
    modifier: Modifier = Modifier, navController: NavController
) {
    Box(
        modifier = modifier
            .background(brush = multiColorComplexGradient(), shape = RoundedCornerShape(16.dp))
            .background(brush = combinedGradient(), shape = RoundedCornerShape(16.dp))
            .fillMaxWidth(),

    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(14.dp),
            modifier = Modifier.padding(start = 10.dp, top = 10.dp)
        )
        {
            Text(
                text = "Расскажите о своих интересах, \nчтобы мы рекомендовали \nполезные встречи",
                style = MyUiTheme.typography.Secondary,
                color = Color.White,


                )
            SolidButton(
                content = {
                    Text(
                        text = "Выбрать интересы",
                        style = MyUiTheme.typography.H5,
                        color = MyUiTheme.colors.brandDefault
                    )
                },
                enabledGradient = multiColorLinearGradientWhite(),
                onClick = {
                    navController.navigate(Screens.OnboardingScreen) {
                        launchSingleTop = true
                    }

                },
            )
        }

        Row(
            horizontalArrangement = Arrangement.End,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.strelka_left),
                contentDescription = "",
            )
            Image(
                painter = painterResource(id = R.drawable.strelka_right),
                contentDescription = "",
            )

        }

    }
}