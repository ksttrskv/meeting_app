package com.example.newUiKit.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.newUiKit.newScreens.AppointmentScreens.AppointmentCodeInputScreen
import com.example.newUiKit.newScreens.AppointmentScreens.AppointmentFinalScreen
import com.example.newUiKit.newScreens.AppointmentScreens.AppointmentNameInputScreen
import com.example.newUiKit.newScreens.AppointmentScreens.AppointmentPhoneInputScreen
import com.example.newUiKit.newScreens.CommunityDetailScreen.CommunityDetailScreen
import com.example.newUiKit.newScreens.EventDetailScreen.EventDetailScreen
import com.example.newUiKit.newScreens.MainScreen.MainScreen
import com.example.newUiKit.newScreens.MembersScreen.MembersScreen
import com.example.newUiKit.newScreens.OnboardingScreen.OnboardingScreen
import com.example.newUiKit.newScreens.ProfileOutsideScreen.ProfileOutsideScreen
import com.example.newUiKit.newScreens.SplashScreen.SplashScreenWb
import com.example.newUiKit.newScreens.UiKitScreen.NewUiKitScreen
import com.example.wbtechnoschoollesson2.R

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    

    NavHost(
        navController = navController,
        startDestination = Screens.SplashScreenWb,
    ) {
//        composable(Screens.Splash) { SplashScreen(navController = navController) }
//        composable(Screens.MyMeetings) { MyMeetingScreen(navController = navController) }
//        composable(Screens.Profile) { ProfileScreen(navController = navController) }
//        composable(Screens.AllMeetings) { AllMeetingScreen(navController = navController) }
//        composable(Screens.MoreScreen) { MoreScreen(navController = navController) }
//        composable(Screens.Communitites) { CommunityScreen(navController = navController) }
//        composable(
//            route = "${Screens.CommunityDetail}/{communityTitle}",
//            arguments = listOf(navArgument("communityTitle") { type = NavType.StringType })
//        ) { backStackEntry ->
//            val communityTitle = backStackEntry.arguments?.getString("communityTitle") ?: ""
//            CommunityDetailScreenOldUi(communityTitle, navController)
//        }
//        composable(
//            route = "${Screens.MeetingDetail}/{meeting}",
//            arguments = listOf(navArgument("meeting") { type = NavType.StringType })
//        ) { backStackEntry ->
//            val meetingId = backStackEntry.arguments?.getString("meeting") ?: ""
//            val meetingViewModel: MeetingViewModel = getViewModel()
//            val meeting = meetingViewModel.getAllMeetings().find { it.title == meetingId }
//            if (meeting != null) {
//                MeetingDetailScreen(meeting, navController, meetingViewModel)
//            }
//        }
//        composable(Screens.Login) { LoginScreen(navController = navController) }
//        composable(Screens.CodeInput) { CodeInputScreen(navController = navController) }
//        composable(Screens.ProfileCreate) { ProfileCreateScreen(navController = navController) }

        // New Screens
        composable(Screens.NewUiKitScreen) { NewUiKitScreen(navController = navController) }
        composable(Screens.OnboardingScreen) { OnboardingScreen(navController = navController) }
        composable(Screens.SplashScreenWb) { SplashScreenWb(navController = navController) }
        composable(Screens.MainScreen) { MainScreen(navController = navController) }
        composable(Screens.AppointmentCodeInputScreen) { AppointmentCodeInputScreen(navController = navController) }
        composable(Screens.AppointmentNameInputScreen) { AppointmentNameInputScreen(navController = navController) }
        composable(Screens.AppointmentPhoneInputScreen) { AppointmentPhoneInputScreen(navController = navController) }
        composable(Screens.AppointmentFinalScreen) { AppointmentFinalScreen(navController = navController) }
        composable(Screens.MembersScreen) { MembersScreen(navController = navController) }
//        composable(Screens.ProfileOutsideScreen) { ProfileOutsideScreen(navController = navController) }
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
                ?: R.drawable.wb // картинка по умолчанию

            EventDetailScreen(
                navController = navController,
                eventTitle = eventTitle,
                eventDate = eventDate,
                eventLocation = eventLocation,
                eventImageRes = eventImage
            )
        }
        composable(
            route = "${Screens.CommunityDetailScreen}/{communityTitle}/{communityAvatarImage}",
            arguments = listOf(
                navArgument("communityTitle") { type = NavType.StringType },
                navArgument("communityAvatarImage") { type = NavType.IntType },
//                navArgument("tags") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val communityTitle = backStackEntry.arguments?.getString("communityTitle") ?: ""
            val communityAvatarImage =
                backStackEntry.arguments?.getInt("communityAvatarImage") ?: R.drawable.wb
//            val tags = backStackEntry.arguments?.getString("tags") ?: ""

            CommunityDetailScreen(
                navController = navController,
                communityTitle = communityTitle,
                communityAvatarImage = communityAvatarImage,
//                tags = tags
            )

        }
        composable(
            route = "${Screens.ProfileOutsideScreen}/{title}/{painter}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("painter") { type = NavType.IntType },
//                navArgument("tags") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val painter =
                backStackEntry.arguments?.getInt("painter") ?: R.drawable.wb
//            val tags = backStackEntry.arguments?.getString("tags") ?: ""

            ProfileOutsideScreen(
                navController = navController,
                title = title, painter = painter
            )

        }

    }
}

