package com.example.presentation.Screens.OnboardingScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.presentation.Screens.OnboardingScreen.useCases.GetAllTagsUseCase
import kotlinx.coroutines.launch

class OnboardingViewModel(
    private val getAllTagsUseCase: GetAllTagsUseCase
) : ViewModel() {

    private val _allTags = MutableLiveData<List<String>>()
    val allTags: LiveData<List<String>> get() = _allTags


    init {
        loadAllTags()
    }

    private fun loadAllTags() {
        viewModelScope.launch {
            _allTags.value = getAllTagsUseCase.execute()
        }
    }
}
