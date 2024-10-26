package com.example.newUiKit.newScreens.MembersScreen.useCases

import com.example.models.UserData
import com.example.newUiKit.newScreens.Repo.UserRepository

class GetMembersUseCase(private val userRepository: UserRepository) {
    fun execute(): List<UserData> {
        return userRepository.getUsers()
    }
}