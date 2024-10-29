package com.example.newUiKit.newScreens.ChooseInterestsScreen.di

import com.example.newUiKit.newScreens.ChooseInterestsScreen.ChooseInterestsViewModel
import com.example.newUiKit.newScreens.ChooseInterestsScreen.repo.TagsInterestsRepositoryImpl
import com.example.newUiKit.newScreens.ChooseInterestsScreen.useCases.GetInterestsTagsUseCase
import com.example.newUiKit.newScreens.OnboardingScreen.repo.TagsRepository
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val chooseInterestsModule = module {
    single<TagsRepository> { TagsInterestsRepositoryImpl() }
    factory { GetInterestsTagsUseCase(get()) }
    viewModel { ChooseInterestsViewModel(get()) }
}
