package com.example.presentation.Screens.ChooseInterestsScreen.di

import com.example.presentation.Screens.ChooseInterestsScreen.ChooseInterestsViewModel
import com.example.presentation.Screens.ChooseInterestsScreen.repo.TagsInterestsRepositoryImpl
import com.example.presentation.Screens.ChooseInterestsScreen.useCases.GetInterestsTagsUseCase
import com.example.presentation.Screens.OnboardingScreen.repo.TagsRepository
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val chooseInterestsModule = module {
    single<TagsRepository> { TagsInterestsRepositoryImpl() }
    factory { GetInterestsTagsUseCase(get()) }
    viewModel { ChooseInterestsViewModel(get()) }
}
