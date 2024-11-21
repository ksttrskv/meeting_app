package com.example.presentation.Screens.MembersScreen.useCases

import com.example.models.UserData
import com.example.presentation.Screens.Repo.UserRepository

class GetMembersUseCase(private val userRepository: UserRepository) {
    fun execute(): List<UserData> {
        return userRepository.getUsers()
    }
}