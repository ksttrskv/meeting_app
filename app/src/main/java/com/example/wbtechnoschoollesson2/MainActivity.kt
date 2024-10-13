package com.example.wbtechnoschoollesson2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import com.example.newUiKit.navigation.NavGraph
import com.example.wbtechnoschoollesson2.atoms.theme.WBTechnoschoolLesson2Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.getInsetsController(window, window.decorView).isAppearanceLightStatusBars =
            true
        window.statusBarColor = android.graphics.Color.TRANSPARENT
        setContent {
            WBTechnoschoolLesson2Theme {
            NavGraph()
            }
        }
    }
}