package com.example.wbtechnoschoollesson2

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.newUiKit.newScreens.EventDetailScreen.EventDetailScreen
import com.example.newUiKit.newScreens.MainScreenPackage.MainScreen
import com.example.newUiKit.newScreens.NewUiKitScreen
import com.example.newUiKit.newScreens.OnboardingScreen
import com.example.newUiKit.newScreens.SplashScreenWb
import com.example.wbtechnoschoollesson2.navigation.Screens
import com.example.wbtechnoschoollesson2.screens.AllMeetingScreen
import com.example.wbtechnoschoollesson2.screens.CodeInputScreen
import com.example.wbtechnoschoollesson2.screens.CommunityDetailScreen
import com.example.wbtechnoschoollesson2.screens.CommunityScreen
import com.example.wbtechnoschoollesson2.screens.LoginScreen
import com.example.wbtechnoschoollesson2.screens.MeetingDetailScreen
import com.example.wbtechnoschoollesson2.screens.MoreScreen
import com.example.wbtechnoschoollesson2.screens.MyMeetingScreen
import com.example.wbtechnoschoollesson2.screens.ProfileCreateScreen
import com.example.wbtechnoschoollesson2.screens.ProfileScreen
import com.example.wbtechnoschoollesson2.screens.ViewModels.MeetingViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    

    NavHost(
        navController = navController,
        startDestination = Screens.SplashScreenWb,
    ) {
        composable(Screens.Splash) { SplashScreen(navController = navController) }
        composable(Screens.MyMeetings) { MyMeetingScreen(navController = navController) }
        composable(Screens.Profile) { ProfileScreen(navController = navController) }
        composable(Screens.AllMeetings) { AllMeetingScreen(navController = navController) }
        composable(Screens.MoreScreen) { MoreScreen(navController = navController) }
        composable(Screens.Communitites) { CommunityScreen(navController = navController) }
        composable(
            route = "${Screens.CommunityDetail}/{communityTitle}",
            arguments = listOf(navArgument("communityTitle") { type = NavType.StringType })
        ) { backStackEntry ->
            val communityTitle = backStackEntry.arguments?.getString("communityTitle") ?: ""
            CommunityDetailScreen(communityTitle, navController)
        }
        composable(
            route = "${Screens.MeetingDetail}/{meeting}",
            arguments = listOf(navArgument("meeting") { type = NavType.StringType })
        ) { backStackEntry ->
            val meetingId = backStackEntry.arguments?.getString("meeting") ?: ""
            val meetingViewModel: MeetingViewModel = getViewModel()
            val meeting = meetingViewModel.getAllMeetings().find { it.title == meetingId }
            if (meeting != null) {
                MeetingDetailScreen(meeting, navController, meetingViewModel)
            }
        }
        composable(Screens.Login) { LoginScreen(navController = navController) }
        composable(Screens.CodeInput) { CodeInputScreen(navController = navController) }
        composable(Screens.ProfileCreate) { ProfileCreateScreen(navController = navController) }

        // New Screens
        composable(Screens.NewUiKitScreen) { NewUiKitScreen(navController = navController) }
        composable(Screens.OnboardingScreen) { OnboardingScreen(navController = navController) }
        composable(Screens.SplashScreenWb) { SplashScreenWb(navController = navController) }
        composable(Screens.MainScreen) { MainScreen(navController = navController) }
        composable(
            route = "${Screens.EventDetailScreen}/{eventTitle}/{eventDate}/{eventLocation}/{eventImage}",
            arguments = listOf(
                navArgument("eventTitle") { type = NavType.StringType },
                navArgument("eventDate") { type = NavType.StringType },
                navArgument("eventLocation") { type = NavType.StringType },
                navArgument("eventImage") { type = NavType.IntType } // Если это ID ресурса
            )
        ) { backStackEntry ->
            val eventTitle = backStackEntry.arguments?.getString("eventTitle") ?: ""
            val eventDate = backStackEntry.arguments?.getString("eventDate") ?: ""
            val eventLocation = backStackEntry.arguments?.getString("eventLocation") ?: ""
            val eventImage = backStackEntry.arguments?.getInt("eventImage")
                ?: R.drawable.wb // Установи изображение по умолчанию

            EventDetailScreen(
                navController = navController,
                eventTitle = eventTitle,
                eventDate = eventDate,
                eventLocation = eventLocation,
                eventImageRes = eventImage
            )
        }
    }
}

