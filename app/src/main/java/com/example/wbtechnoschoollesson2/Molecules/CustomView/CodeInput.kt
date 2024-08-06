package com.example.wbtechnoschoollesson2.Molecules.CustomView

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wbtechnoschoollesson2.atoms.theme.UiTheme
import com.example.wbtechnoschoollesson2.atoms.theme.WBTechnoschoolLesson2Theme

const val CODE_LENGHT = 4

@Composable
fun CodeInput(modifier: Modifier = Modifier, actionDone: (code: String) -> Unit) {
    var pin by remember { mutableStateOf("") }
    val focusManager = LocalFocusManager.current
    BasicTextField(
        modifier = modifier.padding(vertical = 16.dp),
        value = pin,
        onValueChange = {  newValue ->
            when {
                newValue.length <= CODE_LENGHT -> {
                    pin = newValue
                    when (newValue.length) {
                        CODE_LENGHT -> {
                            focusManager.clearFocus()
                            actionDone(newValue)
                        }
                    }
                }
            }
        },
        decorationBox = {
            Row(
                modifier = Modifier.height(34.dp),
                horizontalArrangement = Arrangement.spacedBy(40.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                repeat(CODE_LENGHT) {
                    NumberOrCircle(code = pin, index = it)
                }
            }
        },

        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.NumberPassword,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                if (pin.length == CODE_LENGHT) {
                    focusManager.clearFocus()
                    actionDone(pin)
                }
            }
        )
    )
}

@Composable
fun NumberOrCircle(code: String, index: Int) {
    val bgcolor = UiTheme.colors.neutralLine
    if (code.isEmpty() || code.lastIndex < index) {
        Canvas(modifier = Modifier.size(24.dp)) {
            drawCircle(bgcolor)
        }
    } else {
        Box(modifier = Modifier.width(24.dp), contentAlignment = Alignment.Center) {
            val safeChar = code.getOrNull(index)?.toString() ?: ""
            Text(
                text = safeChar,
                style = UiTheme.typography.heading1
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    WBTechnoschoolLesson2Theme {
        CodeInput {}
    }
}