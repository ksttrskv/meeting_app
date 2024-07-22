package com.example.wbtechnoschoollesson2.di


import com.example.wbtechnoschoollesson2.screens.ViewModels.AllMeetingViewModel
import com.example.wbtechnoschoollesson2.screens.ViewModels.CodeInputViewModel
import com.example.wbtechnoschoollesson2.screens.ViewModels.CommunityViewModel
import com.example.wbtechnoschoollesson2.screens.ViewModels.LoginScreenViewModel
import com.example.wbtechnoschoollesson2.screens.ViewModels.MeetingViewModel
import com.example.wbtechnoschoollesson2.screens.ViewModels.MoreScreenViewModel
import com.example.wbtechnoschoollesson2.screens.ViewModels.MyMeetingViewModel
import com.example.wbtechnoschoollesson2.screens.ViewModels.ProfileCreateViewModel
import com.example.wbtechnoschoollesson2.screens.ViewModels.ProfileViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    // Определяем ViewModel
    viewModelOf(:: MeetingViewModel)
    viewModelOf(::ProfileViewModel)
    viewModelOf(::MoreScreenViewModel)
    viewModel { AllMeetingViewModel(get()) }
    viewModel { CommunityViewModel(get()) }
    viewModelOf(::LoginScreenViewModel)
    viewModelOf(::CodeInputViewModel)
    viewModelOf(::ProfileCreateViewModel)
    viewModel { MyMeetingViewModel(get()) }
}