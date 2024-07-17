package com.example.wbtechnoschoollesson2.screens.ViewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wbtechnoschoollesson2.R
import com.example.wbtechnoschoollesson2.screens.Community
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class CommunityViewModel : ViewModel(), KoinComponent {

    private val communityRepository: CommunityRepository by inject()

    private val _communities = MutableStateFlow<List<Community>>(emptyList())
    val communities: StateFlow<List<Community>> = _communities

    init {
        loadCommunities()
    }

    class CommunityRepositoryImpl : CommunityRepository {

        override suspend fun getAllCommunities(): List<Community> {
            // Здесь можно загрузить данные о сообществах из сети, БД или другого источника
            return listOf(
                Community("Designa", "10 000 человек", R.drawable.communityavatar),
                Community("Designa", "10 000 человек", R.drawable.communityavatar),
                Community("Designa", "10 000 человек", R.drawable.communityavatar),
                Community("Designa", "10 000 человек", R.drawable.communityavatar),
                Community("Designa", "10 000 человек", R.drawable.communityavatar),
                Community("Designa", "10 000 человек", R.drawable.communityavatar),
                Community("Designa", "10 000 человек", R.drawable.communityavatar),
                Community("Designa", "10 000 человек", R.drawable.communityavatar),
                Community("Designa", "10 000 человек", R.drawable.communityavatar),
                Community("Designa", "10 000 человек", R.drawable.communityavatar),
                Community("Designa", "10 000 человек", R.drawable.communityavatar)
            )
        }
    }

    private fun loadCommunities() {
        viewModelScope.launch {
            _communities.value = communityRepository.getAllCommunities()
        }
    }
}

interface CommunityRepository {
    suspend fun getAllCommunities(): List<Community>
}