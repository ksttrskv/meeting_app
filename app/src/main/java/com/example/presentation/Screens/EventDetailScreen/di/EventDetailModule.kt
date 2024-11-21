package com.example.presentation.Screens.EventDetailScreen.di

import com.example.presentation.Screens.EventDetailScreen.EventDetailViewModel
import com.example.presentation.Screens.EventDetailScreen.repo.EventDetailRepository
import com.example.presentation.Screens.EventDetailScreen.repo.EventDetailRepositoryImpl
import com.example.presentation.Screens.EventDetailScreen.useCases.GetCommunityEventsUseCase
import com.example.presentation.Screens.EventDetailScreen.useCases.GetEventDetailsUseCase
import com.example.presentation.Screens.EventDetailScreen.useCases.GetEventMembersUseCase
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val eventDetailModule = module {
    single<EventDetailRepository> { EventDetailRepositoryImpl() }
    factory { GetEventDetailsUseCase(get()) }
    factory { GetEventMembersUseCase(get()) }
    factory { GetCommunityEventsUseCase(get()) }
    viewModelOf(::EventDetailViewModel)

}