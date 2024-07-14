@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.wbtechnoschoollesson2.screens

import com.example.wbtechnoschoollesson2.Molecules.MeetingCard
import com.example.wbtechnoschoollesson2.Molecules.ProfileAvatar
import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.wbtechnoschoollesson2.R
import com.example.wbtechnoschoollesson2.atoms.theme.UiTheme
import com.example.wbtechnoschoollesson2.atoms.theme.WBTechnoschoolLesson2Theme
import com.example.wbtechnoschoollesson2.uiKitScreen.ButtonIconLine
import com.example.wbtechnoschoollesson2.uiKitScreen.SearchView
import com.example.wbtechnoschoollesson2.uiKitScreen.TypographyLine1


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProfileScreen() {
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 46.dp)
            .background(Color.White)
    ) {
        item {
            Spacer(modifier = Modifier.size(46.dp))
            ProfileAvatar(
                avatarResId = R.drawable.avatarpw1,
                isEditing = false,
                size = 100.dp
            )
        }
        item {
            Spacer(modifier = Modifier.size(20.dp))
            TypographyLine1(
                title = "Иван Иванов",
                subTitle = "+7 952 812-22-00"
            )
        }
        item {
            Spacer(modifier = Modifier.size(20.dp))
            ButtonIconLine(color = UiTheme.colors.brandColorDefault, enabled = true)
        }

    }

}





@Preview(showBackground = true)
@Composable
fun PreviewProfileAvatar() {
    WBTechnoschoolLesson2Theme {
        ProfileScreen()
    }
    }








