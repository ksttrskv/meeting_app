package com.example.newUiKit.newScreens.CommunityDetailScreen.di

import com.example.newUiKit.newScreens.CommunityDetailScreen.CommunityDetailViewModel
import com.example.newUiKit.newScreens.CommunityDetailScreen.repo.CommunityRepository
import com.example.newUiKit.newScreens.CommunityDetailScreen.repo.CommunityRepositoryImpl
import com.example.newUiKit.newScreens.CommunityDetailScreen.useCases.GetCommunityDetailsUseCase
import com.example.newUiKit.newScreens.CommunityDetailScreen.useCases.GetCommunityMembersUseCase
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val communityDetailModule = module {
    single<CommunityRepository> { CommunityRepositoryImpl() }
    factory { GetCommunityDetailsUseCase(get()) }
    factory { GetCommunityMembersUseCase(get()) }
    viewModelOf(::CommunityDetailViewModel)
}