package com.example.newUiKit.newInputFields

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.newUiKit.newTheme.MyUiTheme
import com.example.wbtechnoschoollesson2.atoms.theme.WBTechnoschoolLesson2Theme

@Composable
fun NewTextInputField(
    focusRequester: FocusRequester,
    query: String,
    onQueryChange: (String) -> Unit,
    placeholderText: String,
    hasError: Boolean = false, // состояние ошибки
    keyboardController: SoftwareKeyboardController? = LocalSoftwareKeyboardController.current,
    localFocusManager: FocusManager = LocalFocusManager.current,
    modifier: Modifier = Modifier
) {
    // Состояние фокуса
    val isFocused = remember { mutableStateOf(false) }

    Row(
        modifier = modifier
            .height(36.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(if (hasError) MyUiTheme.colors.newErrorBgColor else MyUiTheme.colors.newOffWhite)
            .border(
                width = 1.dp,
                color = if (isFocused.value) MyUiTheme.colors.newBorderColor else Color.Transparent, // Обводка при фокусе
                shape = RoundedCornerShape(16.dp)
            )
            .padding(start = 12.dp)
            .onFocusChanged { focusState -> isFocused.value = focusState.isFocused },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Row(
            modifier = Modifier.weight(1f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            BasicTextField(
                value = query,
                modifier = Modifier
                    .padding(vertical = 10.dp)
                    .focusRequester(focusRequester)
                    .fillMaxWidth()
                    .height(24.dp),
                onValueChange = { input ->
                    onQueryChange(input)
                },
                singleLine = true,
                textStyle = MyUiTheme.typography.primary,
                decorationBox = { innerTextField ->
                    Placeholder(
                        isVisible = query.isEmpty(),
                        placeholderText = placeholderText
                    )
                    innerTextField()
                },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    keyboardType = KeyboardType.Text,
                ),
                keyboardActions = KeyboardActions(
                    onNext = {
                        keyboardController?.hide()
                        localFocusManager.clearFocus()
                    }
                )
            )
        }
    }
}

@Composable
private fun Placeholder(
    modifier: Modifier = Modifier,
    isVisible: Boolean,
    placeholderText: String,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        if (isVisible) {
            Text(
                text = placeholderText,
                color = MyUiTheme.colors.newNeutralDisabled,
                style = MyUiTheme.typography.primary,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NewTextInputPreview() {
    WBTechnoschoolLesson2Theme {
        NewTextInputView(onNameChange = {})
    }
}
