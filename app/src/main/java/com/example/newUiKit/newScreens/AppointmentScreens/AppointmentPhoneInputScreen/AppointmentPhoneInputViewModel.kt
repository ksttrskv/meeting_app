package com.example.newUiKit.newScreens.AppointmentScreens.AppointmentPhoneInputScreen

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class AppointmentPhoneInputViewModel : ViewModel() {
    // Полный номер телефона
    private val _phoneNumber = MutableStateFlow("")
    val phoneNumber: StateFlow<String> = _phoneNumber.asStateFlow()

    // Статус активации кнопки
    private val _isButtonEnabled = MutableStateFlow(false)
    val isButtonEnabled: StateFlow<Boolean> = _isButtonEnabled.asStateFlow()

    // Метод для обновления номера телефона
    fun updatePhoneNumber(phone: String) {
        _phoneNumber.value = phone

        // Проверка, что номер телефона заполнен полностью
        // Учитываем длину номера с кодом страны
        _isButtonEnabled.value = phone.length == PHONE_NUMBER_SIZE
    }

    companion object {
        private const val PHONE_NUMBER_SIZE = 10 // Длина телефона без кода страны
    }
}