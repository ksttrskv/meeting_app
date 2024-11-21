package com.example.room.di

import androidx.room.Room
import com.example.room.AppDatabase
import com.example.room.RoomInitializer
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(
            get(),
            AppDatabase::class.java,
            "app_database"
        ).build()
    }

    single { get<AppDatabase>().eventDao() }
    single { get<AppDatabase>().communityDao() }
    single { RoomInitializer(get(), get()) }
}
