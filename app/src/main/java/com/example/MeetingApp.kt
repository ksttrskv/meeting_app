package com.example

import android.app.Application
import com.example.domain.di.domainModule
import com.example.newUiKit.newScreens.ChooseInterestsScreen.di.chooseInterestsModule
import com.example.newUiKit.newScreens.CommunityDetailScreen.di.communityDetailModule
import com.example.newUiKit.newScreens.EventDetailScreen.di.eventDetailModule
import com.example.newUiKit.newScreens.MainScreen.di.mainScreenModule
import com.example.newUiKit.newScreens.MembersScreen.di.membersModule
import com.example.newUiKit.newScreens.OnboardingScreen.di.onboardingModule
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
                    chooseInterestsModule
                )
            )
        }
    }
}