package com.example.newUiKit.newInputFields

import android.util.Log
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.text.input.TextFieldValue
import com.example.newUiKit.newTheme.MyUiTheme


@Composable
fun WbSearchView(modifier: Modifier = Modifier) {
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


    WbSearchBar(
        focusRequester = focusRequester,
        query = query,
        onQueryChange = onQueryChange,
        onQuerySearch = onQuerySearch,
        placeholderText = "Найти встречи и сообщества",
        searchIconColor = MyUiTheme.colors.newSecondaryColor,
        modifier = modifier // Используем переданный модификатор
            .fillMaxHeight()

    )
}