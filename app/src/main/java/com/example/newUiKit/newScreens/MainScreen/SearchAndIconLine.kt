package com.example.newUiKit.newScreens.MainScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.newUiKit.navigation.Screens
import com.example.newUiKit.newInputFields.WbSearchView
import com.example.wbtechnoschoollesson2.R

@Composable
fun SearchAndIconLine(navController: NavController) {
    Row(modifier = Modifier
        .padding(start = 16.dp, end = 16.dp)
        .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        WbSearchView(modifier = Modifier.weight(1f))
        Image(
            painter = painterResource(id = R.drawable.user_icon),
            contentDescription = "user icon",
            modifier = Modifier
                .size(44.dp)
                .clickable { navController.navigate(Screens.ProfileInsideScreen) }
        )
    }
}

//@Preview(showBackground = true)
//@Composable
//fun SearchAndIconPreview() {
//    MyMeetingAppTheme {
//        SearchAndIconLine()
//    }
//}
