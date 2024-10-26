package com.example

import android.app.Application
import com.example.domain.di.domainModule
import com.example.newUiKit.newScreens.CommunityDetailScreen.di.communityDetailModule
import com.example.newUiKit.newScreens.MembersScreen.di.membersModule
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
                    membersModule
                )
            )
        }
    }
}