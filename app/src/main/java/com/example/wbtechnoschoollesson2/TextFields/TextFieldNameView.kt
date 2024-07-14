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
    onQueryChange: (TextFieldValue) -> Unit,
    query: TextFieldValue
) {

    val focusRequester = remember { FocusRequester() }

    TextInputField(
        focusRequester = focusRequester,
        query = query,
        onQueryChange = onQueryChange,
        placeholderText = stringResource(id = R.string.enter_name),
        modifier = Modifier
            .fillMaxWidth()
            .height(36.dp)

    )
}