package com.example.presentation.Screens.MembersScreen.di

import com.example.presentation.Screens.MembersScreen.MembersViewModel
import com.example.presentation.Screens.MembersScreen.useCases.GetMembersUseCase
import com.example.presentation.Screens.Repo.UserRepository
import com.example.presentation.Screens.Repo.UserRepositoryImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val membersModule = module {
    single<UserRepository> { UserRepositoryImpl() }
    factory { GetMembersUseCase(get()) }
    viewModel { MembersViewModel(get()) }
}