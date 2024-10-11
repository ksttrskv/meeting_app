package com.example.newUiKit.newScreens.EventDetailScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.newUiKit.newTheme.MyUiTheme
import com.example.newUiKit.newTheme.multiColorLinearGradient
import com.example.wbtechnoschoollesson2.R
import com.example.wbtechnoschoollesson2.atoms.buttons.NewCustomButton
import com.example.wbtechnoschoollesson2.atoms.theme.WBTechnoschoolLesson2Theme

@Composable
fun PopupButton() {

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(elevation = 16.dp)
            .background(Color.Transparent),
        shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp), // Скругление углов
        color = Color.White,
//                    elevation = 16.dp // Устанавливаем elevation для тени
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = "Всего 30 мест. Если передумаете — отпишитесь",
                style = MyUiTheme.typography.Secondary,
                color = MyUiTheme.colors.newBrandDefault,
                modifier = Modifier.padding(top = 10.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            NewCustomButton(
                content = {
                    Text(text = stringResource(R.string.sign_up_for_a_meeting))
                },
                textColor = Color.White,
                enabledGradient = multiColorLinearGradient(),
                disabledColor = Color.Gray,
                enabled = true,
                onClick = {},
            )
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPopupButton() {
    WBTechnoschoolLesson2Theme {
        PopupButton()
    }
}