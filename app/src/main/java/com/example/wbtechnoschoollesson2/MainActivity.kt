package com.example.wbtechnoschoollesson2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.wbtechnoschoollesson2.atoms.theme.WBTechnoschoolLesson2Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            WBTechnoschoolLesson2Theme {
                NavGraph()
            }
        }
    }
}

