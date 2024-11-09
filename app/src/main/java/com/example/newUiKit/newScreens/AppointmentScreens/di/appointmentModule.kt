package com.example.newUiKit.newScreens.AppointmentScreens.di

import com.example.newUiKit.newScreens.AppointmentScreens.AppointmentCodeInputScreen.AppointmentCodeInputViewModel
import com.example.newUiKit.newScreens.AppointmentScreens.AppointmentNameInputScreen.AppointmentNameInputViewModel
import com.example.newUiKit.newScreens.AppointmentScreens.AppointmentPhoneInputScreen.AppointmentPhoneInputViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appointmentModule = module {
    viewModel { AppointmentNameInputViewModel() }
    viewModel { AppointmentCodeInputViewModel() }
    viewModel { AppointmentPhoneInputViewModel() }
}