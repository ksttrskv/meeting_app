package com.example.newUiKit.newScreens.ProfileOutsideScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.newUiKit.Tags.SmallTagsList
import com.example.newUiKit.newTheme.MyMeetingAppTheme
import com.example.newUiKit.newTheme.MyUiTheme
import com.example.wbtechnoschoollesson2.R

@Composable
fun ProfileInfoCard(
    modifier: Modifier = Modifier,
    name: String,
    location: String,
    info: String,
    tags: List<String>
) {

//    val tags = listOf("Тестирование", "Разработка", "Дизайн", "Продакт менеджер", "Бэкенд")
    Column(modifier = modifier.fillMaxWidth()) {
        Text(
            text = name,
            style = MyUiTheme.typography.Huge
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = location,
            style = MyUiTheme.typography.H4
        )
        Spacer(modifier = Modifier.height(2.dp))

        Text(
            text = info,
            style = MyUiTheme.typography.Secondary
        )
        Spacer(modifier = Modifier.height(16.dp))

        SmallTagsList(tags = tags)
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            Image(
                painter = painterResource(id = R.drawable.habr),
                contentDescription = "",
                modifier = Modifier.size(52.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Image(
                painter = painterResource(id = R.drawable.network_telegram),
                contentDescription = "",
                modifier = Modifier.size(52.dp),
            )

        }
    }


}

@Preview(showBackground = true)
@Composable
fun PreviewProfileInfoCard() {
    MyMeetingAppTheme {
        val tags = listOf("Тестирование", "Разработка", "Дизайн", "Продакт менеджер", "Бэкенд")
        ProfileInfoCard(
            name = "Cthutq",
            location = "jfoejf",
            info = "reiojfgnjuiehfiu   uiwefghweuijhfuw ewufhweuhf",
            tags = tags
        )
    }
}