package com.example.newUiKit.newScreens.AppointmentScreens.di

import com.example.newUiKit.newScreens.AppointmentScreens.AppointmentNameInputScreen.AppointmentNameInputViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appointmentModule = module {
    viewModel { AppointmentNameInputViewModel() }
}