package com.example.wbtechnoschoollesson2


import com.example.wbtechnoschoollesson2.screens.ViewModels.AllMeetingViewModel
import com.example.wbtechnoschoollesson2.screens.ViewModels.CodeInputViewModel
import com.example.wbtechnoschoollesson2.screens.ViewModels.CommunityRepository
import com.example.wbtechnoschoollesson2.screens.ViewModels.CommunityViewModel
import com.example.wbtechnoschoollesson2.screens.ViewModels.LoginScreenViewModel
import com.example.wbtechnoschoollesson2.screens.ViewModels.MeetingRepository
import com.example.wbtechnoschoollesson2.screens.ViewModels.MeetingViewModel
import com.example.wbtechnoschoollesson2.screens.ViewModels.MoreScreenViewModel
import com.example.wbtechnoschoollesson2.screens.ViewModels.MyMeetingViewModel
import com.example.wbtechnoschoollesson2.screens.ViewModels.ProfileCreateViewModel
import com.example.wbtechnoschoollesson2.screens.ViewModels.ProfileViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    // Определяем ViewModel
    viewModel { MeetingViewModel() }
    viewModel { ProfileViewModel() }
    viewModel { MoreScreenViewModel() }
    single { AllMeetingViewModel.MeetingRepositoryImpl() as MeetingRepository }
    viewModel { AllMeetingViewModel() }
    viewModel { MyMeetingViewModel() }
    single { CommunityViewModel.CommunityRepositoryImpl() as CommunityRepository }
    viewModel { CommunityViewModel() }
    viewModel { LoginScreenViewModel() }
    viewModel { CodeInputViewModel() }
    viewModel { ProfileCreateViewModel() }
}