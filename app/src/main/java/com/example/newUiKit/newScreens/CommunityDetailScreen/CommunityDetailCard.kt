package com.example.newUiKit.newScreens.CommunityDetailScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.example.newUiKit.Tags.MediumTagsList
import com.example.newUiKit.newTheme.MyUiTheme

@Composable
fun CommunityDetailCard(
    communityTitle: String,
    communityAvatar: Painter,
    modifier: Modifier = Modifier
) {
    val tags = listOf("Разработка", "Карьера", "Тестирование", "Дизайн", "Бизнес")
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Image(
            painter = communityAvatar,
            contentDescription = "Community avatar",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(168.dp)
                .clip(shape = RoundedCornerShape(16.dp))
        )

        Text(
            text = communityTitle,
            style = MyUiTheme.typography.H1
        )
        MediumTagsList(tags = tags)
    }

}

//@Preview(showBackground = true)
//@Composable
//fun PreviewCommunityDetailCard() {
//    WBTechnoschoolLesson2Theme {
//        CommunityDetailCard(communityTitle = "The IT Crowd", communityAvatar = painterResource(id = R.drawable.zapuskaem_gus))
//    }
//}
