package com.example.presentation.molecules

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.presentation.Theme.MyMeetingAppTheme
import com.example.presentation.Theme.MyUiTheme
import com.google.accompanist.flowlayout.FlowRow


@Composable
fun SmallTag(
    text: String,
    isSelected: Boolean,
    onSelectedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
//            .fillMaxWidth()
            .background(
                color = if (isSelected) MyUiTheme.colors.brandDefault else MyUiTheme.colors.offWhite,
                shape = RoundedCornerShape(8.dp)
            )
            .clickable { onSelectedChange(!isSelected) }
            .padding(horizontal = 6.dp, vertical = 2.dp)
    ) {
        Text(
            text = text,
            style = MyUiTheme.typography.Secondary,
            color = if (isSelected) MyUiTheme.colors.offWhite else MyUiTheme.colors.brandDefault,
            textAlign = TextAlign.Center,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
fun MediumTag(
    text: String,
    isSelected: Boolean,
    onSelectedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .padding(4.dp)
            .background(
                color = if (isSelected) MyUiTheme.colors.brandDefault else MyUiTheme.colors.offWhite,
                shape = RoundedCornerShape(8.dp)
            )
            .clickable { onSelectedChange(!isSelected) }
            .padding(8.dp)
    ) {
        Text(
            text = text,
            style = MyUiTheme.typography.H5,
            color = if (isSelected) MyUiTheme.colors.offWhite else MyUiTheme.colors.brandDefault,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun BigTag(
    text: String,
    isSelected: Boolean,
    onSelectedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .padding(4.dp)
            .background(
                color = if (isSelected) MyUiTheme.colors.brandDefault else MyUiTheme.colors.offWhite,
                shape = RoundedCornerShape(8.dp)
            )
            .clickable { onSelectedChange(!isSelected) }
            .padding(vertical = 12.dp, horizontal = 10.dp)
    ) {
        Text(
            text = text,
            style = MyUiTheme.typography.H6,
            color = if (isSelected) MyUiTheme.colors.offWhite else MyUiTheme.colors.brandDefault,
            textAlign = TextAlign.Center
        )
    }
}


@Composable
fun BigTagsList(tags: List<String>, modifier: Modifier = Modifier) {
    FlowRow(
        modifier = modifier,
        mainAxisSpacing = 8.dp, // Расстояние между тегами по горизонтали
        crossAxisSpacing = 8.dp // Расстояние между тегами по вертикали
    ) {
        tags.forEach { tag ->
            var isTagSelected by remember { mutableStateOf(false) }

            BigTag(
                text = tag,
                isSelected = isTagSelected,
                onSelectedChange = { isTagSelected = it }
            )
        }
    }
}


@Composable
fun SmallTagsList(tags: List<String>) {
    FlowRow(
        modifier = Modifier.fillMaxWidth(),
        mainAxisSpacing = 8.dp, // Расстояние между тегами по горизонтали
        crossAxisSpacing = 8.dp // Расстояние между тегами по вертикали
    ) {
        tags.forEach { tag ->
            var isTagSelected by remember { mutableStateOf(false) }

            SmallTag(
                text = tag,
                isSelected = isTagSelected,
                onSelectedChange = { isTagSelected = it }
            )
        }
    }
}


@Composable
fun MediumTagsList(tags: List<String>, modifier: Modifier = Modifier) {
    FlowRow(
        modifier = modifier
    ) {
        tags.forEach { tag ->
            var isTagSelected by remember { mutableStateOf(false) }

            MediumTag(
                text = tag,
                isSelected = isTagSelected,
                onSelectedChange = { isTagSelected = it }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TagsPreview() {
    MyMeetingAppTheme {
        Column {
            MediumTag(text = "Subscribe", isSelected = false, onSelectedChange = {})
            BigTag(text = "Дизайн", isSelected = true, onSelectedChange = {})
            SmallTag(text = "Тестирование", isSelected = true, onSelectedChange = {})
        }

    }
}


