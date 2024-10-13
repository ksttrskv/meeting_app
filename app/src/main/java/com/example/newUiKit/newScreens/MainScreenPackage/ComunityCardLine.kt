package com.example.newUiKit.newScreens.MainScreenPackage

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.newUiKit.NewMolecules.CommunityCard
import com.example.newUiKit.navigation.Screens
import com.example.wbtechnoschoollesson2.R

@Composable
fun CommunityCardLine(navController: NavController) {
    val communities = listOf(
        CommunityData(
            title = "Супер тестировщики",
            imageRes = R.drawable.zapuskaem_gus
        ),
        CommunityData(
            title = "The IT Crowd",
            imageRes = R.drawable.comp_img
        ),
        CommunityData(
            title = "Супер тестировщики",
            imageRes = R.drawable.zapuskaem_gus
        ),
        CommunityData(
            title = "Супер тестировщики",
            imageRes = R.drawable.zapuskaem_gus
        ),
        CommunityData(
            title = "Супер тестировщики",
            imageRes = R.drawable.zapuskaem_gus
        ),
        CommunityData(
            title = "Супер тестировщики",
            imageRes = R.drawable.zapuskaem_gus
        ),

        )
    LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp)) {

        itemsIndexed(communities) { index, community ->
            CommunityCard(
                title = community.title,
                painter = painterResource(id = community.imageRes),
                onClick = {
                    navController.navigate(
                        "${Screens.CommunityDetailScreen}/${community.title}/${community.imageRes}"
                    ) {
                        launchSingleTop = true
                    }
                },
                modifier = Modifier
                    .padding(start = if (index == 0) 16.dp else 0.dp) // Паддинг для первого элемента
            )
        }

    }
}

data class CommunityData(
    val title: String,
    val imageRes: Int,
)