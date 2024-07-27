package com.example.wbtechnoschoollesson2.screens.ViewModels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ProfileViewModel : ViewModel() {
    private val _userName = MutableStateFlow("Иван")
    val userName: StateFlow<String> = _userName

    private val _userSurname = MutableStateFlow("Иванов")
    val userSurname: StateFlow<String> = _userSurname

    private val _userPhone = MutableStateFlow("+7 952 812-22-00")
    val userPhone: StateFlow<String> = _userPhone

    fun setUserName(name: String) {
        _userName.value = name
    }
    fun setUserSurname(surname: String) {
        _userSurname.value = surname
    }

    fun setUserPhone(phone: String) {
        _userPhone.value = phone
    }
    fun updateUserProfile(name: String, phone: String) {
        _userName.value = name
        _userPhone.value = phone
    }
}