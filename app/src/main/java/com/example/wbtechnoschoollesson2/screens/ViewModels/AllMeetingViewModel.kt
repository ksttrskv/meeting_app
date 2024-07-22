package com.example.wbtechnoschoollesson2.screens.ViewModels

import MeetingRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Meeting
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class AllMeetingViewModel(private val meetingRepository: MeetingRepository) : ViewModel(), KoinComponent {

    private val _allMeetings = MutableStateFlow<List<Meeting>>(emptyList())
    val allMeetings: StateFlow<List<Meeting>> = _allMeetings

    private val _activeMeetings = MutableStateFlow<List<Meeting>>(emptyList())
    val activeMeetings: StateFlow<List<Meeting>> = _activeMeetings

    init {
        loadMeetings()
    }

    private fun loadMeetings() {
        viewModelScope.launch {
            val meetings = meetingRepository.getMeetings()
            _allMeetings.value = meetings
            _activeMeetings.value = meetings.filter { !it.isFinished }
        }
    }
}


