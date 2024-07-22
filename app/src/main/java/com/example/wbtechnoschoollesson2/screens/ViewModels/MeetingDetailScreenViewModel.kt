package com.example.wbtechnoschoollesson2.screens.ViewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wbtechnoschoollesson2.screens.Meeting
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MeetingViewModel : ViewModel() {
    private val _isGoing = MutableStateFlow(false)
    val isGoing: StateFlow<Boolean> get() = _isGoing

    fun updateIsGoing() {
        _isGoing.value = !_isGoing.value
    }

    fun setIsGoing(value: Boolean) {
        viewModelScope.launch {
            _isGoing.value = value
        }

    }
    fun getAllMeetings(): List<Meeting> {
            // Здесь можно загрузить данные о встречах из сети, БД или другого источника
            return listOf(
                Meeting("Developer meeting", "13.09.2024", "Москва", true),
                Meeting("Another meeting", "15.10.2024", "Санкт-Петербург", false),
                Meeting("Third meeting", "20.11.2024", "Новосибирск", false),
                Meeting("Developer meeting", "13.09.2024", "Москва", true),
                Meeting("Another meeting", "15.10.2024", "Санкт-Петербург", false),
                Meeting("Third meeting", "20.11.2024", "Новосибирск", false),
                Meeting("Developer meeting", "13.09.2024", "Москва", true),
                Meeting("Another meeting", "15.10.2024", "Санкт-Петербург", false),
                Meeting("Third meeting", "20.11.2024", "Новосибирск", false)
            )
        }

    }
