package com.example.newUiKit.newScreens.CommunityDetailScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.models.CommunityDetailData
import com.example.models.EventData
import com.example.models.UserData
import com.example.newUiKit.newScreens.CommunityDetailScreen.useCases.GetCommunityDetailsUseCase
import com.example.newUiKit.newScreens.CommunityDetailScreen.useCases.GetCommunityMembersUseCase
import com.example.newUiKit.newScreens.CommunityDetailScreen.useCases.GetPastCommunityEventsUseCase
import com.example.newUiKit.newScreens.CommunityDetailScreen.useCases.GetUpcomingCommunityEventsUseCase

class CommunityDetailViewModel(
    private val getCommunityDetailsUseCase: GetCommunityDetailsUseCase,
    private val getCommunityMembersUseCase: GetCommunityMembersUseCase,
    private val getUpcomingCommunityEvents: GetUpcomingCommunityEventsUseCase,
    private val getPastCommunityEvents: GetPastCommunityEventsUseCase
) : ViewModel() {

    private val _communityDetails = MutableLiveData<CommunityDetailData>()
    val communityDetails: LiveData<CommunityDetailData> get() = _communityDetails

    private val _communityMembers = MutableLiveData<List<UserData>>()
    val communityMembers: LiveData<List<UserData>> get() = _communityMembers

    private val _upcomingCommunityEvents = MutableLiveData<List<EventData>>()
    val upcomingCommunityEvents: LiveData<List<EventData>> get() = _upcomingCommunityEvents

    private val _pastCommunityEvents = MutableLiveData<List<EventData>>()
    val pastCommunityEvents: LiveData<List<EventData>> get() = _pastCommunityEvents

    fun loadCommunityDetails() {
        _communityDetails.value = getCommunityDetailsUseCase.execute()

    }

    fun loadUpcomingCommunityEvents() {
        _upcomingCommunityEvents.value = getUpcomingCommunityEvents.execute()
    }

    fun loadPastCommunityEvents() {
        _pastCommunityEvents.value = getPastCommunityEvents.execute()
    }

    fun loadCommunityMembers() {
        _communityMembers.value = getCommunityMembersUseCase.execute()
    }
}