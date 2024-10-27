package com.example.newUiKit.newScreens.SplashScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.newUiKit.Theme.MyMeetingAppTheme
import com.example.newUiKit.navigation.Screens
import com.example.wbtechnoschoollesson2.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreenWb(navController: NavController) {
    val context = LocalContext.current // Получаем контекст

    LaunchedEffect(key1 = true) {
        delay(3000)
        navController.navigate(Screens.OnboardingScreen) {
            popUpTo("splashwb") { inclusive = false }
        }
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.splashscreen),
            contentDescription = "splash screen",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = R.drawable.wb),
                contentDescription = "splash screen",
            )
            Spacer(modifier = Modifier.height(20.dp))
            Image(
                painter = painterResource(id = R.drawable.events),
                contentDescription = "splash screen",
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenWbPreview() {
    val navController = rememberNavController()
    MyMeetingAppTheme {
        SplashScreenWb(navController = navController)
    }
}