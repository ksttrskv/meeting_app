package com.example.presentation.Screens.ChooseInterestsScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.presentation.Theme.MyMeetingAppTheme
import com.example.presentation.Theme.MyUiTheme
import com.example.presentation.Theme.multiColorLinearGradient
import com.example.presentation.molecules.BigTagsList
import com.example.presentation.navigation.Screens
import com.example.wbtechnoschoollesson2.atoms.buttons.CustomButton
import org.koin.androidx.compose.getViewModel


@Composable
fun ChooseInterestsScreen(
    navController: NavController,
    viewModel: ChooseInterestsViewModel = getViewModel()
) {
//    val tags = listOf(
//        "Дизайн", "Разработка", "Продакт менеджмент", "Проджект менеджмент",
//        "Backend", "Frontend", "Mobile", "Тестирование", "Продажи",
//        "Бизнес", "Безопасность", "Web", "Девопс", "Маркетинг", "Аналитика"
//    )
    val tags by viewModel.allTags.observeAsState(emptyList())
    Box(
        modifier = Modifier
            .padding(top = 50.dp)
            .fillMaxSize(),
        contentAlignment = Alignment.TopStart
    ) {
        Column(modifier = Modifier.padding(horizontal = 16.dp)) {

            Text(
                text = "Интересы",
                style = MyUiTheme.typography.Huge
            )
            Text(
                text = "Выберите интересы, чтобы мы рекомендовали полезные встречи",
                style = MyUiTheme.typography.regular
            )
            Spacer(modifier = Modifier.height(24.dp))
            BigTagsList(tags = tags)
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.BottomCenter
            ) {
                CustomButton(
                    content = { Text(text = "Сохранить") },
                    textColor = Color.White,
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
                )

            }
        }
    }

}


@Preview(showBackground = true)
@Composable
fun OnboardingScreenPreview() {
    val navController = rememberNavController()
    MyMeetingAppTheme {
        ChooseInterestsScreen(navController = navController)
    }
}