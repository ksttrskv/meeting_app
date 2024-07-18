package com.example.wbtechnoschoollesson2.screens.ViewModels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class LoginScreenViewModel : ViewModel() {

    private val _userPhoneInput = MutableStateFlow("+7 952 812-22-00")
    val userPhoneInput: StateFlow<String>  = _userPhoneInput

    fun onPhoneChanged(phone: String) {
        _userPhoneInput.value = phone
    }
}
