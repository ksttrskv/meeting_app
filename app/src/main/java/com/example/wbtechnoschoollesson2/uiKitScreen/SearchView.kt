package com.example.wbtechnoschoollesson2.uiKitScreen

import android.util.Log
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.wbtechnoschoollesson2.ui.search.SearchBar
import com.example.wbtechnoschoollesson2.ui.theme.UiTheme

@Composable
fun SearchView() {
    val focusRequester = remember { FocusRequester() }
    var query by remember { mutableStateOf(TextFieldValue("")) }

    // Функция для обработки изменений в поле поиска
    val onQueryChange: (TextFieldValue) -> Unit = { newQuery ->
        query = newQuery
    }

    // Функция для обработки действия поиска
    val onQuerySearch: (TextFieldValue) -> Unit = { searchQuery ->
        // Обработка логики поиска здесь
        Log.d("SearchView", "Searching for: ${searchQuery.text}")
    }


    SearchBar(
        focusRequester = focusRequester,
        query = query,
        onQueryChange = onQueryChange,
        onQuerySearch = onQuerySearch,
        placeholderText = "Поиск",
        searchIconColor = UiTheme.colors.neutralDisabled,
        modifier = Modifier.fillMaxWidth()
            .height(36.dp)

    )
}