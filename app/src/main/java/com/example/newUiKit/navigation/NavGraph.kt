package com.example.newUiKit.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.newUiKit.newScreens.AppointmentScreens.AppointmentCodeInputScreen.AppointmentCodeInputScreen
import com.example.newUiKit.newScreens.AppointmentScreens.AppointmentFinalScreen.AppointmentFinalScreen
import com.example.newUiKit.newScreens.AppointmentScreens.AppointmentNameInputScreen.AppointmentNameInputScreen
import com.example.newUiKit.newScreens.AppointmentScreens.AppointmentPhoneInputScreen.AppointmentPhoneInputScreen
import com.example.newUiKit.newScreens.ChooseInterestsScreen.ChooseInterestsScreen
import com.example.newUiKit.newScreens.CommunityDetailScreen.CommunityDetailScreen
import com.example.newUiKit.newScreens.EventDetailScreen.EventDetailScreen
import com.example.newUiKit.newScreens.MainScreen.MainScreen
import com.example.newUiKit.newScreens.MembersScreen.MembersScreen
import com.example.newUiKit.newScreens.OnboardingScreen.OnboardingScreen
import com.example.newUiKit.newScreens.ProfileDeleteScreen.ProfileDeleteScreen
import com.example.newUiKit.newScreens.ProfileEditScreen.ProfileEditScreen
import com.example.newUiKit.newScreens.ProfileInsideScreen.ProfileInsideScreen
import com.example.newUiKit.newScreens.ProfileOutsideScreen.ProfileOutsideScreen
import com.example.newUiKit.newScreens.SplashScreen.SplashScreenWb
import com.example.newUiKit.newScreens.UiKitScreen.NewUiKitScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    

    NavHost(
        navController = navController,
        startDestination = Screens.SplashScreenWb,
    ) {

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
        composable(Screens.ProfileInsideScreen) { ProfileInsideScreen(navController = navController) }
        composable(Screens.ProfileEditScreen) { ProfileEditScreen(navController = navController) }
        composable(Screens.ChooseInterestsScreen) { ChooseInterestsScreen(navController = navController) }
        composable(Screens.ProfileDeleteScreen) { ProfileDeleteScreen(navController = navController) }
//        composable(
//            route = "${Screens.AppointmentNameInputScreen}/{eventTitle}/{eventDate}/{eventLocation}",
//            arguments = listOf(
//                navArgument("eventTitle") { type = NavType.StringType },
//                navArgument("eventDate") { type = NavType.StringType },
//                navArgument("eventLocation") { type = NavType.StringType },
//            )
//        ) { backStackEntry ->
//            val eventTitle = backStackEntry.arguments?.getString("eventTitle") ?: ""
//            val eventDate = backStackEntry.arguments?.getString("eventDate") ?: ""
//            val eventLocation = backStackEntry.arguments?.getString("eventLocation") ?: ""
//            val eventImage = backStackEntry.arguments?.getString("eventImage")
//                ?: ""// картинка по умолчанию
////            val viewModel: AppointmentNameInputViewModel = getViewModel()
////            viewModel.setEventData(eventTitle, eventDate, eventLocation)
//
//            AppointmentNameInputScreen(
//                navController = navController,
//                eventTitle = eventTitle,
//                eventDate = eventDate,
//                eventLocation = eventLocation,
//                eventImageRes = eventImage
////                viewModel = viewModel
//            )
//        }
        composable(
            route = "${Screens.EventDetailScreen}/{eventTitle}/{eventDate}/{eventLocation}/{eventImage}",
            arguments = listOf(
                navArgument("eventTitle") { type = NavType.StringType },
                navArgument("eventDate") { type = NavType.StringType },
                navArgument("eventLocation") { type = NavType.StringType },
                navArgument("eventImage") { type = NavType.StringType } // Если это ID ресурса
            )
        ) { backStackEntry ->
            val eventTitle = backStackEntry.arguments?.getString("eventTitle") ?: ""
            val eventDate = backStackEntry.arguments?.getString("eventDate") ?: ""
            val eventLocation = backStackEntry.arguments?.getString("eventLocation") ?: ""
            val eventImage = backStackEntry.arguments?.getString("eventImage")
                ?: ""// картинка по умолчанию

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
                navArgument("communityAvatarImage") { type = NavType.StringType },
//                navArgument("tags") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val communityTitle = backStackEntry.arguments?.getString("communityTitle") ?: ""
            val communityAvatarImage =
                backStackEntry.arguments?.getString("communityAvatarImage") ?: ""
//            val tags = backStackEntry.arguments?.getString("tags") ?: ""

            CommunityDetailScreen(
                navController = navController,
                communityTitle = communityTitle,
                communityAvatarImage = communityAvatarImage,
//                tags = tags
            )

        }
        composable(
            route = "${Screens.ProfileOutsideScreen}/{title}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType },
//                navArgument("tags") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val image =
                backStackEntry.arguments?.getString("image") ?: ""
//            val tags = backStackEntry.arguments?.getString("tags") ?: ""

            ProfileOutsideScreen(
                navController = navController,
                title = title, image = image
            )

        }

    }
}

