package com.example.newUiKit.newScreens.CommunityDetailScreen.di

import com.example.newUiKit.newScreens.CommunityDetailScreen.CommunityDetailViewModel
import com.example.newUiKit.newScreens.CommunityDetailScreen.repo.CommunityDetailRepository
import com.example.newUiKit.newScreens.CommunityDetailScreen.repo.CommunityDetailRepositoryImpl
import com.example.newUiKit.newScreens.CommunityDetailScreen.repo.CommunityEventsRepository
import com.example.newUiKit.newScreens.CommunityDetailScreen.repo.CommunityEventsRepositoryImpl
import com.example.newUiKit.newScreens.CommunityDetailScreen.useCases.GetCommunityDetailsUseCase
import com.example.newUiKit.newScreens.CommunityDetailScreen.useCases.GetCommunityMembersUseCase
import com.example.newUiKit.newScreens.CommunityDetailScreen.useCases.GetPastCommunityEventsUseCase
import com.example.newUiKit.newScreens.CommunityDetailScreen.useCases.GetUpcomingCommunityEventsUseCase
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