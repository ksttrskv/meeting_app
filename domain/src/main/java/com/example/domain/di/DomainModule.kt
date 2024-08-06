package com.example.domain.di

//import com.example.domain.stubs.ProfileRepositoryStub
import MeetingRepository
import com.example.domain.repository.ProfileRepository
import com.example.domain.stubs.CommunityStub
import com.example.domain.stubs.MeetingRepositoryStub
import com.example.domain.stubs.ProfileRepositoryStub
import com.example.domain.stubs.SaveCommunityUseCaseStub
import com.example.domain.stubs.UpdateCommunityUseCaseStub
import com.example.domain.usecases.implementation.GetCommunityDetailUseCaseImpl
import com.example.domain.usecases.implementation.GetMeetingsByCommunityUseCaseImpl
import com.example.domain.usecases.implementation.MeetingRepositoryImpl
import com.example.domain.usecases.interfaces.GetCommunityDetailUseCase
import com.example.domain.usecases.interfaces.GetCommunityUseCase
import com.example.domain.usecases.interfaces.GetMeetingsByCommunityUseCase
import com.example.domain.usecases.interfaces.GetUserProfileUseCase
import com.example.domain.usecases.interfaces.SaveCommunityUseCase
import com.example.domain.usecases.interfaces.SaveUserProfileUseCase
import com.example.domain.usecases.interfaces.UpdateCommunityUseCase
import org.koin.dsl.module

val domainModule = module {
    single<GetCommunityUseCase> { CommunityStub() }
    single<SaveCommunityUseCase> { SaveCommunityUseCaseStub() }
    single<UpdateCommunityUseCase> { UpdateCommunityUseCaseStub() }
    single<MeetingRepository> { MeetingRepositoryStub() }
    single<GetCommunityDetailUseCase> { GetCommunityDetailUseCaseImpl() }
    single<GetMeetingsByCommunityUseCase> { GetMeetingsByCommunityUseCaseImpl(get()) }



    single<MeetingRepository> { MeetingRepositoryImpl() }
    single<ProfileRepository> { ProfileRepositoryStub() }

    // Provide Use Cases
    factory { GetUserProfileUseCase(get()) }
    factory { SaveUserProfileUseCase(get()) }



}