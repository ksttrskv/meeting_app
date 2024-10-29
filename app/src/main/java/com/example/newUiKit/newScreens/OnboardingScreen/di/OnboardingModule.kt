package com.example.newUiKit.newScreens.OnboardingScreen.di

import com.example.newUiKit.newScreens.OnboardingScreen.OnboardingViewModel
import com.example.newUiKit.newScreens.OnboardingScreen.repo.TagsRepository
import com.example.newUiKit.newScreens.OnboardingScreen.repo.TagsRepositoryImpl
import com.example.newUiKit.newScreens.OnboardingScreen.useCases.GetAllTagsUseCase
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val onboardingModule = module {
    single<TagsRepository> { TagsRepositoryImpl() }
    factory { GetAllTagsUseCase(get()) }
    viewModelOf(::OnboardingViewModel)


}
