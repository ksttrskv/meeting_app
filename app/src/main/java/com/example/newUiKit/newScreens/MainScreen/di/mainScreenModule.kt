package com.example.newUiKit.newScreens.MainScreen.di

import com.example.newUiKit.newScreens.MainScreen.MainScreenViewModel
import com.example.newUiKit.newScreens.MainScreen.repo.CommunityRepository
import com.example.newUiKit.newScreens.MainScreen.repo.CommunityRepositoryImpl
import com.example.newUiKit.newScreens.MainScreen.repo.EventsRepository
import com.example.newUiKit.newScreens.MainScreen.repo.EventsRepositoryImpl
import com.example.newUiKit.newScreens.MainScreen.useCases.GetCommunitiesUseCase
import com.example.newUiKit.newScreens.MainScreen.useCases.GetEventsUseCase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainScreenModule = module {
//    single { ApiService.create() }
    single<EventsRepository> { EventsRepositoryImpl() }
    single<CommunityRepository> { CommunityRepositoryImpl() }
    factory { GetEventsUseCase(get()) }
    factory { GetCommunitiesUseCase(get()) }
    viewModel { MainScreenViewModel(get(), get()) }
}