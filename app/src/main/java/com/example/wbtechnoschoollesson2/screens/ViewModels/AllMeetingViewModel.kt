package com.example.wbtechnoschoollesson2.screens.ViewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wbtechnoschoollesson2.screens.Meeting
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.koin.androidx.compose.inject
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class AllMeetingViewModel : ViewModel(), KoinComponent {

    private val meetingRepository: MeetingRepository by inject()

    private val _allMeetings = MutableStateFlow<List<Meeting>>(emptyList())
    val allMeetings: StateFlow<List<Meeting>> = _allMeetings

    private val _activeMeetings = MutableStateFlow<List<Meeting>>(emptyList())
    val activeMeetings: StateFlow<List<Meeting>> = _activeMeetings

    init {
        loadMeetings()
    }


    class MeetingRepositoryImpl : MeetingRepository {

        override fun getAllMeetings(): List<Meeting> {
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

    private fun loadMeetings() {
        viewModelScope.launch {
            val meetings = meetingRepository.getAllMeetings()
            _allMeetings.value = meetings
            _activeMeetings.value = meetings.filter { !it.isFinished }
        }
    }
}

interface MeetingRepository {
    fun getAllMeetings(): List<Meeting>
}

