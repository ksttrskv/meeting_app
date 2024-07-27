package com.example.wbtechnoschoollesson2.screens.ViewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.UserProfile
import com.example.domain.usecases.interfaces.GetUserProfileUseCase
import com.example.domain.usecases.interfaces.SaveUserProfileUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProfileCreateViewModel(
    private val getUserProfileUseCase: GetUserProfileUseCase,
    private val saveUserProfileUseCase: SaveUserProfileUseCase
) : ViewModel() {

    private val _name = MutableStateFlow("")
    val name: StateFlow<String> = _name

    private val _surname = MutableStateFlow("")
    val surname: StateFlow<String> = _surname

    init {
//        loadUserProfile()
    }

    private fun loadUserProfile() {
        viewModelScope.launch {
            getUserProfileUseCase.execute().collect { userProfile ->
                _name.value = userProfile.name
                _surname.value = userProfile.surname
            }
        }
    }

    fun onNameChanged(newName: String) {
        _name.value = newName
    }

    fun onSurnameChanged(newSurname: String) {
        _surname.value = newSurname
    }

    fun saveUserProfile() {
        viewModelScope.launch {
            val userProfile = UserProfile(_name.value, _surname.value)
            saveUserProfileUseCase.execute(userProfile).collect { success ->
                if (success) {
                    // Handle success if needed
                }
            }
        }
    }
}