package com.example.wbtechnoschoollesson2.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wbtechnoschoollesson2.Molecules.AvatarRow
import com.example.wbtechnoschoollesson2.Molecules.CommunityCard
import com.example.wbtechnoschoollesson2.Molecules.MeetingCard
import com.example.wbtechnoschoollesson2.Molecules.ProfileAvatar
import com.example.wbtechnoschoollesson2.R
import com.example.wbtechnoschoollesson2.atoms.theme.UiTheme
import com.example.wbtechnoschoollesson2.atoms.theme.WBTechnoschoolLesson2Theme
import com.example.wbtechnoschoollesson2.uiKitScreen.ButtonLine
import com.example.wbtechnoschoollesson2.uiKitScreen.ChipsLine
import com.example.wbtechnoschoollesson2.uiKitScreen.Heading
import com.example.wbtechnoschoollesson2.uiKitScreen.SearchView
import com.example.wbtechnoschoollesson2.uiKitScreen.TypographyLine

@Composable
fun UiKitScreen(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(56.dp)

    ) {
        item {
            Column(
                verticalArrangement = Arrangement.spacedBy(56.dp)
            ) {
                Heading(text = "Buttons")
                ButtonLine(color = UiTheme.colors.brandColorDefault, enabled = true)
                ButtonLine(color = UiTheme.colors.brandColorDark, enabled = true)
                ButtonLine(color = UiTheme.colors.brandColorDefault, enabled = false)
            }
        }
        item {
            Column(
                verticalArrangement = Arrangement.spacedBy(56.dp)
            ) {
                Heading(text = "Typography")
                TypographyLine(
                    title = "Heading 1",
                    subTitle = "SF Pro Display/32/Bold",
                    typographyStyle = UiTheme.typography.heading1
                )
                TypographyLine(
                    title = "Heading 2",
                    subTitle = "SF Pro Display/32/Bold",
                    typographyStyle = UiTheme.typography.heading2
                )
                TypographyLine(
                    title = "Subheading 1",
                    subTitle = "Pro Display18/SemiBold",
                    typographyStyle = UiTheme.typography.subheading1
                )
                TypographyLine(
                    title = "Subheading 2",
                    subTitle = "Pro Display18/SemiBold",
                    typographyStyle = UiTheme.typography.subheading2
                )
                TypographyLine(
                    title = "Body Text 1",
                    subTitle = "Pro Display18/SemiBold",
                    typographyStyle = UiTheme.typography.bodyText1
                )
                TypographyLine(
                    title = "Body Text 2",
                    subTitle = "SF Pro Display14/Regular",
                    typographyStyle = UiTheme.typography.bodyText2
                )
                TypographyLine(
                    title = "Metadata 1",
                    subTitle = "SF Pro Display14/Regular",
                    typographyStyle = UiTheme.typography.metadata1
                )
                TypographyLine(
                    title = "Metadata 2",
                    subTitle = "SF Pro Display14/Regular",
                    typographyStyle = UiTheme.typography.metadata2
                )
                TypographyLine(
                    title = "Metadata 3",
                    subTitle = "Pro Display18/SemiBold",
                    typographyStyle = UiTheme.typography.metadata3
                )
            }
        }
        item {
            Column(
                verticalArrangement = Arrangement.spacedBy(56.dp)
            ) {
                Heading(text = "Icon and Image")
                Icon(
                    painter = painterResource(id = R.drawable.ic_group),
                    contentDescription = null,
                    modifier = Modifier.size(width = 24.dp, height = 24.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.avatar),
                    contentDescription = null,
                    modifier = Modifier.size(width = 56.dp, height = 56.dp)

                )
            }
        }
        item {
            Heading(text = "Search")
            SearchView()
        }
        item {
            Heading(text = "Chips")
            ChipsLine()

        }
        item {
            Heading(text = "Events")
            MeetingCard(
                title = "Developer meeting",
                painter = painterResource(id = R.drawable.avatar),
                date = "13.09.2024",
                location = "Москва",
                isFinished = true,
                onClick = {}
            )

            MeetingCard(
                title = "Developer meeting",
                painter = painterResource(id = R.drawable.ic_group),
                date = "13.09.2024",
                location = "Москва",
                isFinished = false,
                onClick = {}
            )


        }
        item {
            Heading(
                text = "Avatar Row"
            )
            AvatarRow(
                avatarResIds = listOf(
                    R.drawable.frame_3293,
                    R.drawable.avatar,
                    R.drawable.ic_group,
                )
            )
        }
        item {
            Heading(
                text = "Community card"
            )
            CommunityCard(
                title = "Developer meeting",
                subtitle = "10 000 человек",
                imageUrl = "https://i.postimg.cc/GmsT4jPq/map-image.png",
                onClick = {}
            )
        }
        item {
            Heading(
                text = "Profile avatar"
            )
            ProfileAvatar(
                avatarResId = R.drawable.avatarpw1,
                isEditing = false,
                size = 24.dp,
                modifier = Modifier.padding(16.dp)
            )
            Spacer(modifier = Modifier.size(16.dp))
            ProfileAvatar(
                avatarResId = R.drawable.avatarpw1,
                isEditing = true,
                size = 24.dp,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewUiKitScreen() {
    WBTechnoschoolLesson2Theme {
        UiKitScreen()
    }
}