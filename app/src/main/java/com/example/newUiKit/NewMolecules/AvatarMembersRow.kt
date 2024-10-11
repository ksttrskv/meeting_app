package com.example.newUiKit.NewMolecules

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.newUiKit.newTheme.MyUiTheme
import com.example.wbtechnoschoollesson2.R
import com.example.wbtechnoschoollesson2.atoms.theme.WBTechnoschoolLesson2Theme

const val MAX_VISIBLE_AVATARS = 5

@Composable
fun AvatarMembersRow(avatarResIds: List<Int>, modifier: Modifier = Modifier) {
    val maxVisibleAvatars = MAX_VISIBLE_AVATARS
    val randomAvatars = avatarResIds.shuffled()

    Row(
        modifier = modifier
            .background(Color.Transparent),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy((-14).dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (randomAvatars.isNotEmpty()) {
                Image(
                    painter = painterResource(id = randomAvatars.first()),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(56.dp)
                        .clip(CircleShape)
                        .zIndex((maxVisibleAvatars - 1).toFloat())
                )

                randomAvatars.drop(1).take(maxVisibleAvatars - 1)
                    .forEachIndexed { index, avatarRes ->
                        Image(
                            painter = painterResource(id = avatarRes),
                            contentDescription = null,
                            modifier = Modifier
                                .size(56.dp)
                                .clip(CircleShape)
                                .zIndex((maxVisibleAvatars + index).toFloat()) // Уменьшение zIndex для наложения
                        )
                    }
            }

            // Счетчик невошедших
            if (avatarResIds.size > maxVisibleAvatars) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape)
                        .background(color = MyUiTheme.colors.newOffWhite)
                        .border(Dp(2F), color = Color.White, shape = CircleShape)
                        .zIndex((maxVisibleAvatars + MAX_VISIBLE_AVATARS).toFloat())

                ) {
                    Text(
                        text = "+${avatarResIds.size - maxVisibleAvatars}",
                        style = MyUiTheme.typography.Secondary.copy(color = MyUiTheme.colors.newBrandDefault),
                    )
                }
            }
        }
    }
}

val members = listOf(
    R.drawable.test_avatar_user,
    R.drawable.test_avatar_user,
    R.drawable.test_avatar_user,
    R.drawable.test_avatar_user,
    R.drawable.test_avatar_user,
    R.drawable.test_avatar_user,
    R.drawable.test_avatar_user,
    R.drawable.test_avatar_user,
    R.drawable.test_avatar_user,
    R.drawable.test_avatar_user,
    R.drawable.test_avatar_user,
    R.drawable.frame_3293,
    R.drawable.frame_3293,

    )

@Preview(showBackground = true)
@Composable
fun PreviewAvatarRows() {
    WBTechnoschoolLesson2Theme {
        AvatarMembersRow(
            avatarResIds = members
        )

    }
}