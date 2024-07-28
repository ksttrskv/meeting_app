package com.example.wbtechnoschoollesson2.TextFields

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.wbtechnoschoollesson2.R

@Composable
fun TextFieldNameView(
    name: String,
    onNameChange: (String) -> Unit
) {

    val focusRequester = remember { FocusRequester() }

    TextInputField(
        focusRequester = focusRequester,
        query = name,
        onQueryChange = { newSurname -> onNameChange(newSurname) },
        placeholderText = stringResource(id = R.string.enter_name),
        modifier = Modifier
            .fillMaxWidth()
            .height(36.dp)

    )
}