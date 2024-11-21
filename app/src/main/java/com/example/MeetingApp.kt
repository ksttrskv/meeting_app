package com.example

import android.app.Application
import com.example.domain.di.domainModule
import com.example.presentation.Screens.AppointmentScreens.di.appointmentModule
import com.example.presentation.Screens.ChooseInterestsScreen.di.chooseInterestsModule
import com.example.presentation.Screens.CommunityDetailScreen.di.communityDetailModule
import com.example.presentation.Screens.EventDetailScreen.di.eventDetailModule
import com.example.presentation.Screens.MainScreen.di.mainScreenModule
import com.example.presentation.Screens.MembersScreen.di.membersModule
import com.example.presentation.Screens.OnboardingScreen.di.onboardingModule
import com.example.room.RoomInitializer
import com.example.room.di.databaseModule
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.ext.android.getKoin
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class MeetingApp : Application() {
    override fun onCreate() {
        super.onCreate()

        // Инициализируем Koin
        startKoin {
            androidContext(this@MeetingApp)
            modules(
                listOf(
                    domainModule,
                    communityDetailModule,
                    membersModule,
                    mainScreenModule,
                    eventDetailModule,
                    onboardingModule,
                    chooseInterestsModule,
                    appointmentModule,
                    databaseModule
                )
            )
        }
        val roomInitializer: RoomInitializer = getKoin().get()

        CoroutineScope(Dispatchers.IO).launch {
            roomInitializer.initialize()
        }
    }
}