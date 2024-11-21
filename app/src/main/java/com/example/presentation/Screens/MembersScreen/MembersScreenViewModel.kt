package com.example.presentation.Screens.MembersScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.models.UserData
import com.example.presentation.Screens.MembersScreen.useCases.GetMembersUseCase

class MembersViewModel(private val getMembersUseCase: GetMembersUseCase) : ViewModel() {
    private val _users = MutableLiveData<List<UserData>>()
    val users: LiveData<List<UserData>> get() = _users

    fun loadUsers() {
        _users.value = getMembersUseCase.execute()
    }
}