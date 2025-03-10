package com.example.presentation.Screens.CommunityDetailScreen.components

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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.presentation.Theme.MyUiTheme
import com.example.presentation.molecules.MediumTagsList

@Composable
fun CommunityDetailCard(
    communityTitle: String,
    communityAvatar: String,
    modifier: Modifier = Modifier
) {
    val tags = listOf("Разработка", "Карьера", "Тестирование", "Дизайн", "Бизнес")
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Image(
            painter = rememberAsyncImagePainter(model = communityAvatar),
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

