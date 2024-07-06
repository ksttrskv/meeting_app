package com.example.wbtechnoschoollesson2

import MainScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.wbtechnoschoollesson2.atoms.theme.WBTechnoschoolLesson2Theme
import com.example.wbtechnoschoollesson2.screens.CommunityScreen
import com.example.wbtechnoschoollesson2.uiKitScreen.UiKitScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            WBTechnoschoolLesson2Theme {
                MainScreen()
            }
        }
    }

}
