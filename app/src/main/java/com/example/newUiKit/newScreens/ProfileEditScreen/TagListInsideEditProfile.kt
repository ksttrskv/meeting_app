package com.example.newUiKit.newScreens.ProfileEditScreen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.newUiKit.Tags.MediumTag
import com.google.accompanist.flowlayout.FlowRow

@Composable
fun TagsListInsideEditProfile(tags: List<String>, modifier: Modifier = Modifier) {
    FlowRow(
        modifier = modifier
//        modifier = Modifier.padding(horizontal = 16.dp),
//        mainAxisSpacing = 2.dp, // Расстояние между тегами по горизонтали
//        crossAxisSpacing = 2.dp // Расстояние между тегами по вертикали
    ) {
        tags.forEach { tag ->
            var isTagSelected by remember { mutableStateOf(false) }

            MediumTag(
                text = tag,
                isSelected = true,
                onSelectedChange = { }
            )
        }
        MediumTag(text = "+ Добавить", isSelected = false, onSelectedChange = {})
    }
}