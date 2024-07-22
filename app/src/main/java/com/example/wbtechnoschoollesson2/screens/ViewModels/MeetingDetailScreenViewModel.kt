package com.example.wbtechnoschoollesson2.screens.ViewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Meeting
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
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
            Meeting(title = "Developer meeting", location = "Москва", date = "15.10.2025", isFinished = true),
            Meeting(title = "Developer meeting", location = "Москва", date = "15.10.2025", isFinished = false),
            Meeting(title = "Developer meeting", location = "Москва", date = "15.10.2025", isFinished = false),
            Meeting(title = "Developer meeting", location = "Москва", date = "15.10.2025", isFinished = true),
            Meeting(title = "Developer meeting", location = "Москва", date = "15.10.2025", isFinished = false),
            Meeting(title = "Developer meeting", location = "Москва", date = "15.10.2025", isFinished = true),
            Meeting(title = "Developer meeting", location = "Москва", date = "15.10.2025", isFinished = false),
            Meeting(title = "Developer meeting", location = "Москва", date = "15.10.2025", isFinished = false),
            Meeting(title = "Developer meeting", location = "Москва", date = "15.10.2025", isFinished = true),
        )
        }

    }
