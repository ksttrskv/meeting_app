package com.example.presentation.inputFields

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.wbtechnoschoollesson2.R

@Composable
fun TextInputView(
    name: String = "",
    onNameChange: (String) -> Unit,
    placeholderContent: @Composable () -> Unit = {
        SimplePlaceholder(placeholderText = stringResource(id = R.string.name_and_lastname))
    },
) {
    val query = remember { mutableStateOf(name) }

    // Состояние ошибки
    val hasError = remember { mutableStateOf(false) }

    // FocusRequester для управления фокусом
    val focusRequester = remember { FocusRequester() }

    // KeyboardController и FocusManager
    val keyboardController = LocalSoftwareKeyboardController.current
    val localFocusManager = LocalFocusManager.current

    InputField(
        focusRequester = focusRequester,
        query = query.value,
        onQueryChange = { newQuery ->
            query.value = newQuery
            onNameChange(newQuery)
        },
        placeholderContent = placeholderContent,
        hasError = hasError.value,
        keyboardController = keyboardController,
        localFocusManager = localFocusManager,
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)

    )
}
