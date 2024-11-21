package com.example.presentation.molecules

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.presentation.Theme.MyMeetingAppTheme
import com.example.wbtechnoschoollesson2.R

@Composable
fun Logo(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .background(color = Color(0xFFF1ECEC)),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.wb_events_logo),
            contentDescription = "wb встречи",
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLogo() {
    MyMeetingAppTheme {
        Logo()
    }
}