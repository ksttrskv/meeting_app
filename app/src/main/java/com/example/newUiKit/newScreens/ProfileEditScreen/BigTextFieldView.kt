package com.example.newUiKit.newScreens.ProfileEditScreen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp

@Composable
fun BigTextFieldView(
    name: String = "",
    onNameChange: (String) -> Unit,
    placeholderText: String = "Расскажите о себе",
) {
    val query = remember { mutableStateOf("") }

    // Состояние ошибки
    val hasError = remember { mutableStateOf(false) }

    // FocusRequester для управления фокусом
    val focusRequester = remember { FocusRequester() }

    // KeyboardController и FocusManager
    val keyboardController = LocalSoftwareKeyboardController.current
    val localFocusManager = LocalFocusManager.current

    AboutMeTextField(
        focusRequester = focusRequester,
        query = query.value,
        onQueryChange = {
            query.value = it
            hasError.value = it.length < 1  // Пример валидации
        },
        placeholderText = placeholderText,
        hasError = hasError.value,
        keyboardController = keyboardController,
        localFocusManager = localFocusManager,
        modifier = Modifier
            .fillMaxWidth()
            .height(102.dp)

    )
}