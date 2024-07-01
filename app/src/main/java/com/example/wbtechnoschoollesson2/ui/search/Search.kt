package com.example.wbtechnoschoollesson2.ui.search

import android.app.DownloadManager.Query
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.room.util.query
import com.example.wbtechnoschoollesson2.R
import com.example.wbtechnoschoollesson2.ui.theme.UiTheme
import com.example.wbtechnoschoollesson2.ui.theme.WBTechnoschoolLesson2Theme
import com.example.wbtechnoschoollesson2.uiKitScreen.SearchView
import com.example.wbtechnoschoollesson2.uiKitScreen.UiKitScreen

@Composable
fun SearchBar(
    focusRequester: FocusRequester,
    query: TextFieldValue,
    onQueryChange: (TextFieldValue) -> Unit,
    onQuerySearch: (TextFieldValue) -> Unit,
    placeholderText: String = "Поиск",
    keyboardController: SoftwareKeyboardController? = LocalSoftwareKeyboardController.current,
    localFocusManager: FocusManager = LocalFocusManager.current,
    searchIconColor: Color = UiTheme.colors.neutralDisabled,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .height(36.dp)
            .clip(RoundedCornerShape(4.dp))
            .background(UiTheme.colors.neutralLine)
            .padding(start = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Row(
            modifier = Modifier.weight(1f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Icon(
                painter = painterResource(R.drawable.vector),
                contentDescription = null,
                tint = searchIconColor
            )

            BasicTextField(
                value = query,
                modifier = Modifier
                    .padding(vertical = 10.dp)
                    .focusRequester(focusRequester)
                    .fillMaxWidth()
                    .height(36.dp),
                onValueChange = { input ->
                    onQueryChange(input)
                },
                singleLine = true,
                textStyle = UiTheme.typography.body1,
                decorationBox = { innerTextField ->
                    Placeholder(
                        isVisible = query.text.isEmpty(),
                        placeholderText = placeholderText
                    )
                    innerTextField()
                },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Search,
                    keyboardType = KeyboardType.Text,
                ),
                keyboardActions = KeyboardActions(
                    onSearch = {
                        onQuerySearch(query)
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
                color = UiTheme.colors.neutralDisabled,
                style = UiTheme.typography.body1,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}



@Preview(showBackground = true)
@Composable
fun PreviewSearch() {
    WBTechnoschoolLesson2Theme {
        SearchView()
    }
}
