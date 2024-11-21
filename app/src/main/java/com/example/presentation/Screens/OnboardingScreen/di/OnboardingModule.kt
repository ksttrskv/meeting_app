package com.example.presentation.Screens.OnboardingScreen.di

import com.example.presentation.Screens.OnboardingScreen.OnboardingViewModel
import com.example.presentation.Screens.OnboardingScreen.repo.TagsRepository
import com.example.presentation.Screens.OnboardingScreen.repo.TagsRepositoryImpl
import com.example.presentation.Screens.OnboardingScreen.useCases.GetAllTagsUseCase
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val onboardingModule = module {
    single<TagsRepository> { TagsRepositoryImpl() }
    factory { GetAllTagsUseCase(get()) }
    viewModelOf(::OnboardingViewModel)


}
