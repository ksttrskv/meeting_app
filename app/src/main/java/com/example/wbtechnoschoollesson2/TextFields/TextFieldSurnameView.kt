package com.example.wbtechnoschoollesson2.TextFields

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.wbtechnoschoollesson2.R

@Composable
fun TextFieldSurnameView() {
    val focusRequester = remember { FocusRequester() }
    var query by remember { mutableStateOf(TextFieldValue("")) }

//    // Функция для обработки изменений в поле
//    val onQueryChange: (TextFieldValue) -> Unit = { newQuery ->
//        query = newQuery
//    }

    TextInputField(
        focusRequester = focusRequester,
        query = query,
        onQueryChange = { newQuery -> query = newQuery },
        placeholderText = stringResource(id = R.string.enter_surname),
        modifier = Modifier
            .fillMaxWidth()
            .height(36.dp)

    )
}