package com.example.newUiKit.newScreens.AppointmentScreens.AppointmentCodeInputScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AppointmentCodeInputViewModel : ViewModel() {
    private val _eventTitle = MutableLiveData<String>()
    val eventTitle: LiveData<String> get() = _eventTitle

    private val _eventDate = MutableLiveData<String>()
    val eventDate: LiveData<String> get() = _eventDate

    private val _eventLocation = MutableLiveData<String>()
    val eventLocation: LiveData<String> get() = _eventLocation

    fun setEventData(title: String, date: String, location: String) {
        _eventTitle.value = title
        _eventDate.value = date
        _eventLocation.value = location
    }

    private val _code = MutableLiveData("")
    val code: LiveData<String> get() = _code

    private val _isButtonEnabled = MediatorLiveData<Boolean>().apply {
        addSource(_code) { code -> value = code.isNotEmpty() }
    }
    val isButtonEnabled: LiveData<Boolean> get() = _isButtonEnabled

    fun onCodeChange(newCode: String) {
        _code.value = newCode
    }
}