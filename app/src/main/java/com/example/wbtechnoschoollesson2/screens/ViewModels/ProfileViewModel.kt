package com.example.wbtechnoschoollesson2.screens.ViewModels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ProfileViewModel : ViewModel() {
    private val _userName = MutableStateFlow("Иван Иванов")
    val userName: StateFlow<String> = _userName

    private val _userPhone = MutableStateFlow("+7 952 812-22-00")
    val userPhone: StateFlow<String> = _userPhone

    fun setUserName(name: String) {
        _userName.value = name
    }

    fun setUserPhone(phone: String) {
        _userPhone.value = phone
    }
}