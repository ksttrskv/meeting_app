package com.example.presentation.Screens.MainScreen.components

import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.presentation.molecules.PersonCard
import com.example.presentation.molecules.users
import com.example.presentation.navigation.Screens

@Composable
fun PersonCardline(navController: NavController) {


    LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
        itemsIndexed(users) { index, user ->
            PersonCard(
                title = user.title,
                imageUrl = user.painter,
                tag = user.tag,
                modifier = Modifier
                    .padding(start = if (index == 0) 16.dp else 0.dp) // Паддинг для первого элемента
                    .clickable {
                        navController.navigate(
                            "${Screens.ProfileOutsideScreen}/${Uri.encode(user.title)}/${
                                Uri.encode(
                                    user.painter
                                )
                            }"
                        ) {
                            launchSingleTop = true
                        }
                    }
            )
        }
    }
}

