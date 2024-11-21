package com.example.presentation.Screens.Repo

import com.example.models.UserData


interface UserRepository {
    fun getUsers(): List<UserData>
}