package com.example.presentation.Screens.ChooseInterestsScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.presentation.Screens.ChooseInterestsScreen.useCases.GetInterestsTagsUseCase
import kotlinx.coroutines.launch

class ChooseInterestsViewModel(
    private val getInterestsTagsUseCase: GetInterestsTagsUseCase
) : ViewModel() {

    private val _allTags = MutableLiveData<List<String>>()
    val allTags: LiveData<List<String>> get() = _allTags


    init {
        loadAllTags()
    }

    private fun loadAllTags() {
        viewModelScope.launch {
            _allTags.value = getInterestsTagsUseCase.execute()
        }
    }
}
