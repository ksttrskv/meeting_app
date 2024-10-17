package com.example.newUiKit.newScreens.MainScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.newUiKit.newInputFields.WbSearchView
import com.example.newUiKit.newTheme.MyMeetingAppTheme
import com.example.wbtechnoschoollesson2.R

@Composable
fun SearchAndIconLine() {
    Row(modifier = Modifier
        .padding(start = 16.dp, end = 16.dp)
        .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        WbSearchView(modifier = Modifier.weight(1f))
        Image(
            painter = painterResource(id = R.drawable.user_icon),
            contentDescription = "user icon",
            modifier = Modifier.size(44.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SearchAndIconPreview() {
    MyMeetingAppTheme {
        SearchAndIconLine()
    }
}
