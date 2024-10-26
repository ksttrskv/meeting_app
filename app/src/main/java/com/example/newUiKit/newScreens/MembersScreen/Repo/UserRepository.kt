package com.example.newUiKit.newScreens.Repo

import com.example.models.UserData


interface UserRepository {
    fun getUsers(): List<UserData>
}