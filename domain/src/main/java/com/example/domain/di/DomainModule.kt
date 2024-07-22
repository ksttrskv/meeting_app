package com.example.domain.di

import com.example.domain.repository.MeetingRepository
import com.example.repository.mock.MockMeetingRepository
import org.koin.dsl.module

val domainModule = module {
    single<MeetingRepository> { MockMeetingRepository() }
}