package com.example.wbtechnoschoollesson2.uiKitScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wbtechnoschoollesson2.atoms.theme.UiTheme

@Composable
fun TypographyLine(
    title: String,
    subTitle: String,
    typographyStyle: TextStyle,
    modifier: Modifier = Modifier
) {
    val text = "The quick brown fox jumps over the lazy dog"
    LazyRow(
        modifier = modifier,
    ) {
        item {
            Column(
                modifier = Modifier
                    .padding(end = 16.dp)
                    .widthIn(180.dp),
            ) {
                Text(
                    text = title,
                    style = UiTheme.typography.subheading1
                )
                Text(
                    text = subTitle,
                    fontSize = 14.sp,
                    lineHeight = 24.sp,
                    color = UiTheme.colors.neutralDisabled
                )
            }

            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = text,
                style = typographyStyle
            )
        }
    }
}

@Composable
fun TypographyLine1(
    title: String,
    subTitle: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .widthIn(180.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text(
            text = title,
            style = UiTheme.typography.bodyText1,
            fontSize = 24.sp,
            lineHeight = 24.sp
        )
        Text(
            text = subTitle,
            fontSize = 16.sp,
            lineHeight = 20.sp,
            color = UiTheme.colors.neutralDisabled
        )
    }

}

