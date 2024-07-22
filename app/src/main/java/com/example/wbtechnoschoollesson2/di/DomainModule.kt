package com.example.wbtechnoschoollesson2.di

import MeetingRepository
import com.example.domain.usecases.implementation.GetCommunityUseCaseImpl
import com.example.domain.usecases.implementation.MeetingRepositoryImpl
import com.example.domain.usecases.interfaces.GetCommunityUseCase
import org.koin.dsl.module

val domainModule = module {
    single<GetCommunityUseCase> { GetCommunityUseCaseImpl() }
    single<MeetingRepository> { MeetingRepositoryImpl() }
}