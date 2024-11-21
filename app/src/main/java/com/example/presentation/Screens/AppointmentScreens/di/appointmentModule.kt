package com.example.presentation.Screens.AppointmentScreens.di

import com.example.presentation.Screens.AppointmentScreens.AppointmentCodeInputScreen.AppointmentCodeInputViewModel
import com.example.presentation.Screens.AppointmentScreens.AppointmentNameInputScreen.AppointmentNameInputViewModel
import com.example.presentation.Screens.AppointmentScreens.AppointmentPhoneInputScreen.AppointmentPhoneInputViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appointmentModule = module {
    viewModel { AppointmentNameInputViewModel() }
    viewModel { AppointmentCodeInputViewModel() }
    viewModel { AppointmentPhoneInputViewModel() }
}