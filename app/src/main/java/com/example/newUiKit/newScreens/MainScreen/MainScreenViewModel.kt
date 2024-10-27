package com.example.newUiKit.newScreens.MainScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.models.CommunityData
import com.example.models.EventData
import com.example.newUiKit.newScreens.MainScreen.useCases.GetCommunitiesUseCase
import com.example.newUiKit.newScreens.MainScreen.useCases.GetEventsUseCase
import kotlinx.coroutines.launch

class MainScreenViewModel(
    private val getUpcomingEventsUseCase: GetEventsUseCase,
    private val getCommunitiesUseCase: GetCommunitiesUseCase
) : ViewModel() {

    private val _events = MutableLiveData<List<EventData>>()
    val events: LiveData<List<EventData>> get() = _events

    private val _communities = MutableLiveData<List<CommunityData>>()
    val communities: LiveData<List<CommunityData>> get() = _communities

    private val _upComingCommunityEvents = MutableLiveData<List<EventData>>()
    val upComingCommunityEvents: LiveData<List<EventData>> get() = _upComingCommunityEvents

    init {
        loadEvents()
        loadCommunities()
        loadUpcomingCommunityEvents()
    }

    private fun loadEvents() {
        viewModelScope.launch {
            _events.value = getUpcomingEventsUseCase.execute()
        }
    }

    private fun loadCommunities() {
        viewModelScope.launch {
            _communities.value = getCommunitiesUseCase.execute()
        }
    }

    private fun loadUpcomingCommunityEvents() {
        viewModelScope.launch {
            _upComingCommunityEvents.value = getUpcomingEventsUseCase.execute()
        }
    }
}

