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
fun TextFieldSurnameView(
    surname: String,
    onSurnameChange: (String) -> Unit
) {
    val focusRequester = remember { FocusRequester() }

    TextInputField(
        focusRequester = focusRequester,
        query = surname,
        onQueryChange = { newSurname -> onSurnameChange(newSurname) },
        placeholderText = stringResource(id = R.string.enter_surname),
        modifier = Modifier
            .fillMaxWidth()
            .height(36.dp)
    )
}