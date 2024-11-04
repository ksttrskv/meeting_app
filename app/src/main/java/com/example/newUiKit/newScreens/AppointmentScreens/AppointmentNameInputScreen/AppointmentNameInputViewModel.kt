package com.example.newUiKit.newScreens.AppointmentScreens.AppointmentNameInputScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AppointmentNameInputViewModel : ViewModel() {
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

    private val _name = MutableLiveData("")
    val name: LiveData<String> get() = _name

    private val _isButtonEnabled = MediatorLiveData<Boolean>().apply {
        addSource(_name) { name -> value = name.isNotEmpty() }
    }
    val isButtonEnabled: LiveData<Boolean> get() = _isButtonEnabled

    fun onNameChange(newName: String) {
        _name.value = newName
    }
}