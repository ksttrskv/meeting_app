package com.example.di

import com.example.newUiKit.newScreens.MembersScreen.MembersViewModel
import com.example.newUiKit.newScreens.Repo.UserRepository
import com.example.newUiKit.newScreens.Repo.UserRepositoryImpl
import com.example.newUiKit.newScreens.UseCases.GetMembersUseCase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<UserRepository> { UserRepositoryImpl() }
    factory { GetMembersUseCase(get()) }
    viewModel { MembersViewModel(get()) }
}