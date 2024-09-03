package com.example.newUiKit.Tags

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.newUiKit.newTheme.MyUiTheme
import com.example.wbtechnoschoollesson2.atoms.theme.WBTechnoschoolLesson2Theme


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
                color = if (isSelected) MyUiTheme.colors.newBrandDefault else MyUiTheme.colors.newOffWhite,
                shape = RoundedCornerShape(8.dp)
            )
            .clickable { onSelectedChange(!isSelected) }
            .padding(horizontal = 6.dp, vertical = 2.dp)
    ) {
        Text(
            text = text,
            style = MyUiTheme.typography.Secondary,
            color = if (isSelected) MyUiTheme.colors.newOffWhite else MyUiTheme.colors.newBrandDefault,
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
                color = if (isSelected) MyUiTheme.colors.newBrandDefault else MyUiTheme.colors.newOffWhite,
                shape = RoundedCornerShape(8.dp)
            )
            .clickable { onSelectedChange(!isSelected) }
            .padding(8.dp)
    ) {
        Text(
            text = text,
            style = MyUiTheme.typography.H5,
            color = if (isSelected) MyUiTheme.colors.newOffWhite else MyUiTheme.colors.newBrandDefault,
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
                color = if (isSelected) MyUiTheme.colors.newBrandDefault else MyUiTheme.colors.newOffWhite,
                shape = RoundedCornerShape(8.dp)
            )
            .clickable { onSelectedChange(!isSelected) }
            .padding(vertical = 12.dp, horizontal = 10.dp)
    ) {
        Text(
            text = text,
            style = MyUiTheme.typography.H6,
            color = if (isSelected) MyUiTheme.colors.newOffWhite else MyUiTheme.colors.newBrandDefault,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TagsPreview() {
    WBTechnoschoolLesson2Theme {
        Column {
            MediumTag(text = "Subscribe", isSelected = false, onSelectedChange = {})
            BigTag(text = "Дизайн", isSelected = true, onSelectedChange = {})
            SmallTag(text = "Тестирование", isSelected = true, onSelectedChange = {})
        }

    }
}