package com.example.newUiKit.newScreens.MainScreenPackage

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.newUiKit.newInputFields.WbSearchView
import com.example.wbtechnoschoollesson2.R

@Composable
fun SearchAndIconLine() {
    Row(modifier = Modifier
        .padding(end = 16.dp)
        .fillMaxWidth()) {
        WbSearchView()
//        Spacer(modifier = Modifier.width(8.dp))
        Image(
            painter = painterResource(id = R.drawable.user_icon),
            contentDescription = "user icon"
        )
    }
}