package com.example.wbtechnoschoollesson2.screens.ViewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wbtechnoschoollesson2.screens.Meeting
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class MyMeetingViewModel : ViewModel(), KoinComponent {

    private val meetingRepository: MeetingRepository by inject()

    private val _plannedMeetings = MutableStateFlow<List<Meeting>>(emptyList())
    val plannedMeetings: StateFlow<List<Meeting>> = _plannedMeetings

    private val _finishedMeetings = MutableStateFlow<List<Meeting>>(emptyList())
    val finishedMeetings: StateFlow<List<Meeting>> = _finishedMeetings

    init {
        loadMeetings()
    }

    private fun loadMeetings() {
        viewModelScope.launch {
            val meetings = meetingRepository.getAllMeetings()
            _plannedMeetings.value = meetings.filter { !it.isFinished }
            _finishedMeetings.value = meetings.filter { it.isFinished }
        }
    }
}