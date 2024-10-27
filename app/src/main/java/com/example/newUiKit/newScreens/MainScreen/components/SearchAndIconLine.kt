package com.example.newUiKit.newScreens.MainScreen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.newUiKit.Theme.MyUiTheme
import com.example.newUiKit.inputFields.SearchView
import com.example.newUiKit.navigation.Screens
import com.example.wbtechnoschoollesson2.R

@Composable
fun SearchAndIconLine(navController: NavController) {
    Row(modifier = Modifier
        .padding(start = 16.dp, end = 16.dp)
        .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        SearchView(modifier = Modifier.weight(1f))
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                painter = painterResource(id = R.drawable.user_icon),
                contentDescription = "user icon",
                tint = MyUiTheme.colors.brandDefault,
                modifier = Modifier
                    .size(44.dp)
                    .clickable { navController.navigate(Screens.ProfileInsideScreen) }
            )
        }

    }
}

