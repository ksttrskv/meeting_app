package com.example.presentation.Screens.CommunityDetailScreen.di

import com.example.presentation.Screens.CommunityDetailScreen.CommunityDetailViewModel
import com.example.presentation.Screens.CommunityDetailScreen.repo.CommunityDetailRepository
import com.example.presentation.Screens.CommunityDetailScreen.repo.CommunityDetailRepositoryImpl
import com.example.presentation.Screens.CommunityDetailScreen.repo.CommunityEventsRepository
import com.example.presentation.Screens.CommunityDetailScreen.repo.CommunityEventsRepositoryImpl
import com.example.presentation.Screens.CommunityDetailScreen.useCases.GetCommunityDetailsUseCase
import com.example.presentation.Screens.CommunityDetailScreen.useCases.GetCommunityMembersUseCase
import com.example.presentation.Screens.CommunityDetailScreen.useCases.GetPastCommunityEventsUseCase
import com.example.presentation.Screens.CommunityDetailScreen.useCases.GetUpcomingCommunityEventsUseCase
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val communityDetailModule = module {
    single<CommunityDetailRepository> { CommunityDetailRepositoryImpl() }
    factory { GetCommunityDetailsUseCase(get()) }
    factory { GetCommunityMembersUseCase(get()) }
    single<CommunityEventsRepository> { CommunityEventsRepositoryImpl() }
    factory { GetUpcomingCommunityEventsUseCase(get()) }
    factory { GetPastCommunityEventsUseCase(get()) }
    viewModelOf(::CommunityDetailViewModel)
}