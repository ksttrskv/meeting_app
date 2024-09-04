package com.example.wbtechnoschoollesson2.screens.ViewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wbtechnoschoollesson2.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

data class MenuItem(
    val title: String,
    val iconResId: Int,
    val route: String
)

class MoreScreenViewModel : ViewModel() {

    private val _menuItems = MutableStateFlow<List<MenuItem>>(emptyList())
    val menuItems: StateFlow<List<MenuItem>> = _menuItems

    init {
        loadMenuItems()
    }

    private fun loadMenuItems() {
        viewModelScope.launch {
            // Здесь загружаем список пунктов меню
            val items = listOf(
                MenuItem("Мои встречи", R.drawable.meeting_ic, "my_meetings"),
                MenuItem("Тема", R.drawable.theme_ic, "new_uikitscreeen"),
                MenuItem("Уведомления", R.drawable.notifications_ic, "onboarding_screen"),
                MenuItem("Безопасность", R.drawable.security_ic, "main_screen"),
                MenuItem("Память и ресурсы", R.drawable.resourse_ic, ""),
                MenuItem("Помощь", R.drawable.help_ic, ""),
                MenuItem("Пригласи друга", R.drawable.invite_ic, "")
            )
            _menuItems.value = items
        }
    }
}