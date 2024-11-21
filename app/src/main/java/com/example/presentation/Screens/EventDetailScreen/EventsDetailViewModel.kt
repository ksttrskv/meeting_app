package com.example.presentation.Screens.EventDetailScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.models.EventData
import com.example.models.EventDetailData
import com.example.models.UserData
import com.example.presentation.Screens.EventDetailScreen.useCases.GetCommunityEventsUseCase
import com.example.presentation.Screens.EventDetailScreen.useCases.GetEventDetailsUseCase
import com.example.presentation.Screens.EventDetailScreen.useCases.GetEventMembersUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class EventDetailViewModel(
    private val getEventDetailUseCase: GetEventDetailsUseCase,
    private val getEventMembersUseCase: GetEventMembersUseCase,
    private val getCommunityEventsUseCase: GetCommunityEventsUseCase
) : ViewModel() {

    private val _isRegistered = MutableStateFlow(false)
    val isRegistered: StateFlow<Boolean> = _isRegistered

    private val _eventDetails = MutableLiveData<EventDetailData>()
    val eventDetails: LiveData<EventDetailData> get() = _eventDetails

    private val _eventMembers = MutableLiveData<List<UserData>>()
    val eventMembers: LiveData<List<UserData>> get() = _eventMembers

    private val _communityEvents = MutableLiveData<List<EventData>>()
    val communityEvents: LiveData<List<EventData>> get() = _communityEvents

//    init {
//        loadEventDetail()
//        loadEventMembers()
//        loadCommunityEvents()
//    }

    fun loadEventDetail() {
        _eventDetails.value = getEventDetailUseCase.execute()

    }

    fun loadEventMembers() {
        _eventMembers.value = getEventMembersUseCase.execute()

    }

    fun loadCommunityEvents() {
        _communityEvents.value = getCommunityEventsUseCase.execute()

    }

    fun toggleRegistration() {
        _isRegistered.value = !_isRegistered.value
    }
}