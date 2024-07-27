package com.example.domain.di

import MeetingRepository
import com.example.domain.repository.ProfileRepository
import com.example.domain.stubs.ProfileRepositoryStub
//import com.example.domain.stubs.ProfileRepositoryStub
import com.example.domain.usecases.implementation.GetCommunityUseCaseImpl
import com.example.domain.usecases.implementation.MeetingRepositoryImpl
import com.example.domain.usecases.interfaces.GetCommunityUseCase
import com.example.domain.usecases.interfaces.GetUserProfileUseCase
import com.example.domain.usecases.interfaces.SaveUserProfileUseCase
import org.koin.dsl.module

val domainModule = module {
    single<GetCommunityUseCase> { GetCommunityUseCaseImpl() }
    single<MeetingRepository> { MeetingRepositoryImpl() }
    single<ProfileRepository> { ProfileRepositoryStub() }

    // Provide Use Cases
    factory { GetUserProfileUseCase(get()) }
    factory { SaveUserProfileUseCase(get()) }



}