package Molecules

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.wbtechnoschoollesson2.R
import com.example.wbtechnoschoollesson2.ui.chips.CustomFilterChip
import com.example.wbtechnoschoollesson2.ui.theme.UiTheme
import com.example.wbtechnoschoollesson2.ui.theme.WBTechnoschoolLesson2Theme


@Composable
fun AvatarRow(avatarResIds: List<Int>) {
    val avatarCount = remember {
       (avatarResIds.size - 5)
    }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy((-16).dp),
        modifier = Modifier.padding(start = 16.dp)
    ) {
        avatarResIds.forEachIndexed { index, resId ->
            Image(
                painter = painterResource(id = resId),
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .zIndex(avatarCount - index.toFloat())
            )
        }
        Text(
            text = "+$avatarCount",
            style = UiTheme.typography.bodyText1,
            fontSize = 16.sp,
            modifier = Modifier
                .padding(start = 16.dp)
                .clip(RoundedCornerShape(8.dp))
                .padding(4.dp)
        )
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewAvatarRow() {
    WBTechnoschoolLesson2Theme {
        AvatarRow(
            avatarResIds = listOf(
                R.drawable.frame_3293,
                R.drawable.avatar,
                R.drawable.ic_group,

            ))

    }
}