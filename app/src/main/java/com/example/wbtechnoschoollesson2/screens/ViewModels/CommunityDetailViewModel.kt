package com.example.wbtechnoschoollesson2.screens.ViewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Community
import com.example.domain.model.Meeting
import com.example.domain.usecases.interfaces.GetCommunityDetailUseCaseOld
import com.example.domain.usecases.interfaces.GetMeetingsByCommunityUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent

class CommunityDetailViewModel(
    private val getCommunityDetailUseCaseOld: GetCommunityDetailUseCaseOld,
    private val getMeetingsByCommunityUseCase: GetMeetingsByCommunityUseCase
) : ViewModel(), KoinComponent {

    private val _community = MutableStateFlow<Community?>(null)
    val community: StateFlow<Community?> = _community

    private val _meetings = MutableStateFlow<List<Meeting>>(emptyList())
    val meetings: StateFlow<List<Meeting>> = _meetings

    fun loadCommunityDetail(communityTitle: String) {
        viewModelScope.launch {
            getCommunityDetailUseCaseOld.execute(communityTitle).collect { communityDetail ->
                _community.value = communityDetail
            }
        }
    }

    fun loadMeetings(communityTitle: String) {
        viewModelScope.launch {
            getMeetingsByCommunityUseCase.execute(communityTitle).collect { meetingList ->
                _meetings.value = meetingList
            }
        }
    }
}