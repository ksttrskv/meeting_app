package com.example.newUiKit.newScreens.CommunityDetailScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.models.CommunityDetailData
import com.example.models.UserData
import com.example.newUiKit.newScreens.CommunityDetailScreen.useCases.GetCommunityDetailsUseCase
import com.example.newUiKit.newScreens.CommunityDetailScreen.useCases.GetCommunityMembersUseCase

class CommunityDetailViewModel(
    private val getCommunityDetailsUseCase: GetCommunityDetailsUseCase,
    private val getCommunityMembersUseCase: GetCommunityMembersUseCase
) : ViewModel() {

    private val _communityDetails = MutableLiveData<CommunityDetailData>()
    val communityDetails: LiveData<CommunityDetailData> get() = _communityDetails

    private val _communityMembers = MutableLiveData<List<UserData>>()
    val communityMembers: LiveData<List<UserData>> get() = _communityMembers

    fun loadCommunityDetails() {
        _communityDetails.value = getCommunityDetailsUseCase.execute()
    }

    fun loadCommunityMembers() {
        _communityMembers.value = getCommunityMembersUseCase.execute()
    }
}