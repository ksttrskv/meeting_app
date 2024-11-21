package com.example.presentation.Screens.CommunityDetailScreen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.presentation.Theme.MyMeetingAppTheme
import com.example.presentation.Theme.MyUiTheme
import com.example.presentation.Theme.multiColorLinearGradient
import com.example.wbtechnoschoollesson2.R
import com.example.wbtechnoschoollesson2.atoms.buttons.CustomButton

@Composable
fun SubscribeButtonAndText() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        CustomButton(
            content = {
                Text(text = stringResource(R.string.subscribe_text))
            },
            textColor = Color.White,
            enabledGradient = multiColorLinearGradient(),
            disabledColor = Color.Gray,
            enabled = true,
            onClick = { },
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(R.string.text_under_the_subscribe_button),
            style = MyUiTheme.typography.Secondary,
            color = MyUiTheme.colors.brandDefault,
        )
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewSubscribeButton() {
    MyMeetingAppTheme {
        SubscribeButtonAndText()
    }
}