package com.example.newUiKit.newScreens.UseCases

import com.example.newUiKit.newScreens.MembersScreen.UserData
import com.example.newUiKit.newScreens.Repo.UserRepository

class GetMembersUseCase(private val userRepository: UserRepository) {
    fun execute(): List<UserData> {
        return userRepository.getUsers()
    }
}