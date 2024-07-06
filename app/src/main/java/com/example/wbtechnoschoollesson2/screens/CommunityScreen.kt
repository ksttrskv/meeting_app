package com.example.wbtechnoschoollesson2.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wbtechnoschoollesson2.Molecules.CommunityCard
import com.example.wbtechnoschoollesson2.R
import com.example.wbtechnoschoollesson2.atoms.theme.UiTheme
import com.example.wbtechnoschoollesson2.atoms.theme.WBTechnoschoolLesson2Theme
import com.example.wbtechnoschoollesson2.uiKitScreen.SearchView

data class Community(
    val title: String,
    val subtitle: String,
    val imageRes: Int
)


@Composable
fun CommunityScreen() {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 24.dp, end = 24.dp)
                .background(Color.White)
        ) {

            item {
                SearchView()
                Spacer(modifier = Modifier.height(16.dp))
            }

            items(communities) { community ->
                CommunityCard(
                    title = community.title,
                    subtitle = community.subtitle,
                    imageRes = community.imageRes,

                    )
                Divider(color = UiTheme.colors.neutralLine, thickness = 1.dp)
                Spacer(modifier = Modifier.height(16.dp))

            }
        }
    }
}

val communities = listOf(
    Community(
        title = "Designa",
        subtitle = "10 000 человек",
        imageRes = R.drawable.communityavatar
    ),
    Community(
        title = "Designa",
        subtitle = "10 000 человек",
        imageRes = R.drawable.communityavatar
    ),
    Community(
        title = "Designa",
        subtitle = "10 000 человек",
        imageRes = R.drawable.communityavatar
    ),
    Community(
        title = "Designa",
        subtitle = "10 000 человек",
        imageRes = R.drawable.communityavatar
    ),
    Community(
        title = "Designa",
        subtitle = "10 000 человек",
        imageRes = R.drawable.communityavatar
    ),
    Community(
        title = "Designa",
        subtitle = "10 000 человек",
        imageRes = R.drawable.communityavatar
    ),
    Community(
        title = "Designa",
        subtitle = "10 000 человек",
        imageRes = R.drawable.communityavatar
    ),
    Community(
        title = "Designa",
        subtitle = "10 000 человек",
        imageRes = R.drawable.communityavatar
    ),
    Community(
        title = "Designa",
        subtitle = "10 000 человек",
        imageRes = R.drawable.communityavatar
    ),
    Community(
        title = "Designa",
        subtitle = "10 000 человек",
        imageRes = R.drawable.communityavatar
    ),
    Community(
        title = "Designa",
        subtitle = "10 000 человек",
        imageRes = R.drawable.communityavatar
    ),
    Community(
        title = "Designa",
        subtitle = "10 000 человек",
        imageRes = R.drawable.communityavatar
    )
)

@Preview(showBackground = true)
@Composable
fun PreviewCommunityScreen() {
    WBTechnoschoolLesson2Theme {
        CommunityScreen()
    }
}