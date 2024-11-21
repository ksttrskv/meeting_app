package com.example.presentation.Screens.ProfileEditScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.presentation.Theme.MyMeetingAppTheme
import com.example.presentation.Theme.MyUiTheme
import com.example.presentation.molecules.MediumTag
import com.example.presentation.navigation.Screens
import com.google.accompanist.flowlayout.FlowRow

@Composable
fun TagsListInsideEditProfile(
    navController: NavController,
    tags: List<String>,
    modifier: Modifier = Modifier
) {

    FlowRow(
        modifier = modifier
            .padding(horizontal = 16.dp),
    ) {
        tags.forEach { tag ->

            MediumTag(
                text = tag,
                isSelected = true,
                onSelectedChange = { }
            )
        }
        Box(
            modifier = modifier
                .padding(4.dp)
                .background(
                    color = MyUiTheme.colors.offWhite,
                    shape = RoundedCornerShape(8.dp)
                )
                .clickable {
                    navController.navigate(
                        Screens.ChooseInterestsScreen
                    )
                }
                .padding(8.dp)
        ) {
            Text(
                text = "+ Добавить",
                style = MyUiTheme.typography.H5,
                color = MyUiTheme.colors.brandDefault,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TagsListInsideEditProfilePreview() {
    val navController = rememberNavController()
    MyMeetingAppTheme {
        val tags = listOf(
            "Дизайн", "Разработка", "Продакт менеджмент", "Проджект менеджмент",
            "Backend", "Frontend", "Mobile"
        )
        TagsListInsideEditProfile(navController = navController, tags = tags)
    }
}