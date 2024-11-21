package com.example.presentation.Screens.MainScreen.di

import com.example.presentation.Screens.MainScreen.MainScreenViewModel
import com.example.presentation.Screens.MainScreen.repo.CommunityRepository
import com.example.presentation.Screens.MainScreen.repo.CommunityRepositoryImpl
import com.example.presentation.Screens.MainScreen.repo.EventsRepository
import com.example.presentation.Screens.MainScreen.repo.EventsRepositoryImpl
import com.example.presentation.Screens.MainScreen.useCases.GetCommunitiesUseCase
import com.example.presentation.Screens.MainScreen.useCases.GetEventsUseCase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainScreenModule = module {
//    single { ApiService.create() }
    single<EventsRepository> { EventsRepositoryImpl(get()) }
    single<CommunityRepository> { CommunityRepositoryImpl(get()) }
    factory { GetEventsUseCase(get()) }
    factory { GetCommunitiesUseCase(get()) }
    viewModel { MainScreenViewModel(get(), get()) }
}