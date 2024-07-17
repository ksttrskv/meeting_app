package com.example.wbtechnoschoollesson2.screens.ViewModels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CodeInputViewModel : ViewModel() {
    private val _code = MutableStateFlow("")
    val code: StateFlow<String> = _code

    fun onCodeChanged(newCode: String) {
        _code.value = newCode
    }
}