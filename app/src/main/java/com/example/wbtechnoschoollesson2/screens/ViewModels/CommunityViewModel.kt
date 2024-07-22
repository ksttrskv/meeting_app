package com.example.wbtechnoschoollesson2.screens.ViewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Community
import com.example.domain.usecases.interfaces.GetCommunityUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent

class CommunityViewModel(
    private val getCommunityUseCase: GetCommunityUseCase
) : ViewModel(), KoinComponent {

    private val _communities = MutableStateFlow<List<Community>>(emptyList())
    val communities: StateFlow<List<Community>> = _communities

    init {
        loadCommunities()
    }

    private fun loadCommunities() {
        viewModelScope.launch {
            getCommunityUseCase.execute().collect { communityList ->
                _communities.value = communityList
            }
        }
    }
}
