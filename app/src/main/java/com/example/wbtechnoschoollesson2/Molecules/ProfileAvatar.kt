package com.example.wbtechnoschoollesson2.Molecules

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.wbtechnoschoollesson2.R
import com.example.wbtechnoschoollesson2.atoms.theme.UiTheme
import com.example.wbtechnoschoollesson2.atoms.theme.WBTechnoschoolLesson2Theme


@Composable
fun ProfileAvatar(
    avatarResId: Int,
    isEditing: Boolean,
    size : Dp,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.size(size*2)
            .background(color = UiTheme.colors.neutralOffWhite, shape = CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = avatarResId),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(size)

        )

        if (isEditing) {
            Box(
                modifier = Modifier
                    .padding(size * 0.02f)
                    .size(size * 0.25f)
                    .clip(CircleShape)
                    .align(Alignment.BottomEnd)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.plus),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewProfileAvatar() {
    WBTechnoschoolLesson2Theme {
        Row(verticalAlignment = Alignment.CenterVertically) {

            ProfileAvatar(
                avatarResId = R.drawable.avatarpw1,
                isEditing = false,
                modifier = Modifier.padding(16.dp),
                size = 100.dp
            )

            Spacer(modifier = Modifier.size(16.dp))
            ProfileAvatar(
                avatarResId = R.drawable.avatarpw1,
                isEditing = true,
                modifier = Modifier.padding(16.dp),
                size = 100.dp
            )
        }
    }
}