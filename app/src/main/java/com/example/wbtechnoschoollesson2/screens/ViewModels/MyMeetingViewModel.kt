package com.example.wbtechnoschoollesson2.screens.ViewModels

import MeetingRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Meeting
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class MyMeetingViewModel(private val meetingRepository: MeetingRepository) : ViewModel() {

    private val _plannedMeetings = MutableStateFlow<List<Meeting>>(emptyList())
    val plannedMeetings: StateFlow<List<Meeting>> = _plannedMeetings

    private val _finishedMeetings = MutableStateFlow<List<Meeting>>(emptyList())
    val finishedMeetings: StateFlow<List<Meeting>> = _finishedMeetings

    init {
        loadMeetings()
    }

    private fun loadMeetings() {
        viewModelScope.launch {
            val meetings = meetingRepository.getMeetings()
            _plannedMeetings.value = meetings.filter { !it.isFinished }
            _finishedMeetings.value = meetings.filter { it.isFinished }
        }
    }
}