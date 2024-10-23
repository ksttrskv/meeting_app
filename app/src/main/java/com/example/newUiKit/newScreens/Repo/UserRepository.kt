package com.example.newUiKit.newScreens.Repo

import com.example.newUiKit.newScreens.MembersScreen.UserData

interface UserRepository {
    fun getUsers(): List<UserData>
}