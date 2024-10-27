package com.example.newUiKit.newScreens.MainScreen.components

import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.newUiKit.molecules.CommunityCard
import com.example.newUiKit.navigation.Screens

@Composable
fun CommunityCardLine(navController: NavController) {
    val communities = listOf(
        CommunityData(
            title = "Супер тестировщики",
            imageRes = "https://www.cv-library.co.uk/career-advice/wp-content/uploads/2018/06/What-is-it-like-working-in-IT-e1651761435165.jpg"
        ),
        CommunityData(
            title = "The IT Crowd",
            imageRes = "https://www.cv-library.co.uk/career-advice/wp-content/uploads/2018/06/What-is-it-like-working-in-IT-e1651761435165.jpg"
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