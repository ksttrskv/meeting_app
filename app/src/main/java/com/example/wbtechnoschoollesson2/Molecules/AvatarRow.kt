package com.example.wbtechnoschoollesson2.Molecules

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.wbtechnoschoollesson2.R
import com.example.wbtechnoschoollesson2.atoms.theme.WBTechnoschoolLesson2Theme

const val MAX_VISIBLE_AVATARS = 5

@Composable
fun AvatarRow(avatarResIds: List<Int>) {
    val maxVisibleAvatars = MAX_VISIBLE_AVATARS
    val randomAvatars = avatarResIds.shuffled()

    Row(
        modifier = Modifier
            .padding(24.dp)
            .background(Color.Transparent),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy((-24).dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (randomAvatars.isNotEmpty()) {
                Image(
                    painter = painterResource(id = randomAvatars.first()),
                    contentDescription = null,
                    modifier = Modifier
                        .size(70.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .zIndex((maxVisibleAvatars + 1).toFloat())
                )

                randomAvatars.drop(1).take(maxVisibleAvatars - 1)
                    .forEachIndexed { index, avatarRes ->
                        Image(
                            painter = painterResource(id = avatarRes),
                            contentDescription = null,
                            modifier = Modifier
                                .size(70.dp)
                                .clip(RoundedCornerShape(16.dp))
                                .zIndex((maxVisibleAvatars - index).toFloat()) // Уменьшение zIndex для наложения
                        )
                    }
            }
        }
        // Счетчик невошедших
        if (avatarResIds.size > maxVisibleAvatars) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(60.dp)
                    .clip(RoundedCornerShape(16.dp))

            ) {
                Text(
                    text = "+${avatarResIds.size - maxVisibleAvatars}",
                    style = MaterialTheme.typography.bodySmall.copy(color = Color.Black),
                    fontSize = 20.sp,
                    modifier = Modifier.padding(end = 36.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAvatarRows() {
    WBTechnoschoolLesson2Theme {
        AvatarRow(
            avatarResIds = listOf(
                R.drawable.frame_3293,
                R.drawable.frame_3293,
                R.drawable.frame_3293,
                R.drawable.frame_3293,
                R.drawable.frame_3293,
                R.drawable.frame_3293,
                R.drawable.frame_3293,
                R.drawable.frame_3293,
                R.drawable.frame_3293,
                R.drawable.frame_3293,
                R.drawable.frame_3293,

                )
        )

    }
}