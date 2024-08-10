package com.example.wbtechnoschoollesson2

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.wbtechnoschoollesson2.navigation.Screens
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    LaunchedEffect(key1 = true) {
        delay(3000)
        navController.navigate(Screens.Login) {
            popUpTo("splash") { inclusive = true }
        }
    }

    Surface(
        color = Color.Transparent,
        modifier = Modifier.fillMaxSize()
    ) {
        val composition by rememberLottieComposition(
            spec = LottieCompositionSpec.RawRes(R.raw.anik_hamster)
        )

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            LottieAnimation(
                composition = composition,
                modifier = Modifier.fillMaxSize(),
                speed = 0.85f
            )
        }
    }
}
