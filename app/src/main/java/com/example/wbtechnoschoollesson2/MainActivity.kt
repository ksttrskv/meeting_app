package com.example.wbtechnoschoollesson2

import MainScreen
import Molecules.MeetingCard
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.wbtechnoschoollesson2.navigation.BottomItem
import com.example.wbtechnoschoollesson2.navigation.Screen1
import com.example.wbtechnoschoollesson2.ui.theme.UiTheme
import com.example.wbtechnoschoollesson2.ui.theme.WBTechnoschoolLesson2Theme
import com.example.wbtechnoschoollesson2.uiKitScreen.Heading
import com.example.wbtechnoschoollesson2.uiKitScreen.SearchView
import com.example.wbtechnoschoollesson2.uiKitScreen.UiKitScreen
import kotlinx.serialization.Serializable

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
