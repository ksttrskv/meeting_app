package com.example.wbtechnoschoollesson2.screens.ViewModels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ProfileCreateViewModel : ViewModel() {
    private val _name = MutableStateFlow("")
    val name: StateFlow<String> = _name

    private val _surname = MutableStateFlow("")
    val surname: StateFlow<String> = _surname

    fun onNameChanged(newName: String) {
        _name.value = newName
    }

    fun onSurnameChanged(newSurname: String) {
        _surname.value = newSurname
    }
}