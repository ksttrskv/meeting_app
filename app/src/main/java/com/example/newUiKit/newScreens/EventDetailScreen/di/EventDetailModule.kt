package com.example.newUiKit.newScreens.EventDetailScreen.di

import com.example.newUiKit.newScreens.EventDetailScreen.EventDetailViewModel
import com.example.newUiKit.newScreens.EventDetailScreen.repo.EventDetailRepository
import com.example.newUiKit.newScreens.EventDetailScreen.repo.EventDetailRepositoryImpl
import com.example.newUiKit.newScreens.EventDetailScreen.useCases.GetCommunityEventsUseCase
import com.example.newUiKit.newScreens.EventDetailScreen.useCases.GetEventDetailsUseCase
import com.example.newUiKit.newScreens.EventDetailScreen.useCases.GetEventMembersUseCase
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val eventDetailModule = module {
    single<EventDetailRepository> { EventDetailRepositoryImpl() }
    factory { GetEventDetailsUseCase(get()) }
    factory { GetEventMembersUseCase(get()) }
    factory { GetCommunityEventsUseCase(get()) }
    viewModelOf(::EventDetailViewModel)

}