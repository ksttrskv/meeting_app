package com.example.newUiKit.newScreens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.newUiKit.Tags.BigTagsList
import com.example.newUiKit.newButtons.WbTextButton
import com.example.newUiKit.newTheme.MyUiTheme
import com.example.newUiKit.newTheme.multiColorLinearGradient
import com.example.wbtechnoschoollesson2.atoms.buttons.NewCustomButton
import com.example.wbtechnoschoollesson2.atoms.theme.UiTheme
import com.example.wbtechnoschoollesson2.atoms.theme.WBTechnoschoolLesson2Theme
import com.example.wbtechnoschoollesson2.uiKitScreen.Heading

@Composable
fun OnboardingScreen(navController: NavController) {
    val tags = listOf(
        "Дизайн", "Разработка", "Продакт менеджмент", "Проджект менеджмент",
        "Backend", "Frontend", "Mobile", "Тестирование", "Продажи",
        "Бизнес", "Безопасность", "Web", "Девопс", "Маркетинг", "Аналитика"
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.TopStart
    ) {
        LazyColumn(modifier = Modifier.padding(horizontal = 16.dp)) {
            item {
                Heading(text = "Интересы")
            }
            item {
                Text(
                    text = "Выберите интересы, чтобы мы рекомендовали полезные встречи",
                    style = MyUiTheme.typography.regular
                )
            }
            item {
                Spacer(modifier = Modifier.height(24.dp))
                BigTagsList(tags = tags)
            }
            item {
                Spacer(modifier = Modifier.height(100.dp))
                NewCustomButton(
                    content = { Text(text = "Сохранить") },
                    textColor = Color.White,
                    enabledGradient = multiColorLinearGradient(),
                    disabledColor = MyUiTheme.colors.newOffWhite,
                    enabled = true,
                    onClick = {
                    }
                )
            }
            item {
                WbTextButton(
                    content = { Text(text = "Расскажу позже") },
                    btnColor = UiTheme.colors.brandColorDefault,
                    textColor = UiTheme.colors.brandColorDefault,
                    onClick = { /*TODO*/ }
                )
            }
        }
    }

}


@Preview(showBackground = true)
@Composable
fun OnboardingScreenPreview() {
    val navController = rememberNavController()
    WBTechnoschoolLesson2Theme {
        OnboardingScreen(navController = navController)
    }
}