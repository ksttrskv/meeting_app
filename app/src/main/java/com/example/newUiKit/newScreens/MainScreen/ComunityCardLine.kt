package com.example.newUiKit.newScreens.MainScreen

import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.newUiKit.NewMolecules.CommunityCard
import com.example.newUiKit.navigation.Screens

@Composable
fun CommunityCardLine(navController: NavController) {
    val communities = listOf(
        CommunityData(
            title = "Супер тестировщики",
            imageRes = "https://itsochi.pro/img/hello/swim.svg"
        ),
        CommunityData(
            title = "The IT Crowd",
            imageRes = "https://itproger.com/img/main_page/mobile-main.svg"
        ),
        CommunityData(
            title = "Супер тестировщики",
            imageRes = "https://legalacademy.ru/images/lfa/ARTICLE/5752648/COVER_LIST/5752660.jpg"
        ),
        CommunityData(
            title = "Супер тестировщики",
            imageRes = "https://ares.by/uploaded/articles/116/116-1653398415-0-23.jpg"
        ),
        CommunityData(
            title = "Супер тестировщики",
            imageRes = "https://legalacademy.ru/images/lfa/ARTICLE/5752648/COVER_LIST/5752660.jpg"
        ),
        CommunityData(
            title = "Супер тестировщики",
            imageRes = "https://legalacademy.ru/images/lfa/ARTICLE/5752648/COVER_LIST/5752660.jpg"
        ),

        )
    LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp)) {

        itemsIndexed(communities) { index, community ->
            CommunityCard(
                title = community.title,
                imageRes = community.imageRes,
                onClick = {
                    navController.navigate(
                        "${Screens.CommunityDetailScreen}/${Uri.encode(community.title)}/${
                            Uri.encode(
                                community.imageRes
                            )
                        }"
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
    val imageRes: String,
)