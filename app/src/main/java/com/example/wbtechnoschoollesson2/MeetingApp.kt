package com.example.wbtechnoschoollesson2

import android.app.Application
import com.example.wbtechnoschoollesson2.di.appModule
import com.example.wbtechnoschoollesson2.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class MeetingApp : Application() {
    override fun onCreate() {
        super.onCreate()

        // Инициализируем Koin
        startKoin {
            androidContext(this@MeetingApp)
            modules(
                listOf(appModule, domainModule))
        }
    }
}