package com.example.newUiKit.newScreens.MembersScreen.di

import com.example.newUiKit.newScreens.MembersScreen.MembersViewModel
import com.example.newUiKit.newScreens.MembersScreen.useCases.GetMembersUseCase
import com.example.newUiKit.newScreens.Repo.UserRepository
import com.example.newUiKit.newScreens.Repo.UserRepositoryImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val membersModule = module {
    single<UserRepository> { UserRepositoryImpl() }
    factory { GetMembersUseCase(get()) }
    viewModel { MembersViewModel(get()) }
}