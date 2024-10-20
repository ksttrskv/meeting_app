package com.example.newUiKit.newScreens.MainScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.newUiKit.NewMolecules.PersonCard
import com.example.newUiKit.newTheme.MyMeetingAppTheme

@Composable
fun PersonCardline() {


    LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
        item {
            PersonCard(
                title = "Мария",
                imageUrl = "https://www.fonvirtual.com/en/wp-content/uploads/2020/03/telecommuting-opt.jpg",
                modifier = Modifier.padding(start = 16.dp),
                tag = "Developer"
            )
        }
        item {
            PersonCard(
                title = "Ирина",
                imageUrl = "https://www.fonvirtual.com/en/wp-content/uploads/2020/03/telecommuting-opt.jpg",
                tag = "Developer"
            )
        }
        item {
            PersonCard(
                title = "Никита",
                imageUrl = "https://www.fonvirtual.com/en/wp-content/uploads/2020/03/telecommuting-opt.jpg",
                tag = "Developer"
            )
        }
        item {
            PersonCard(
                title = "Илья",
                imageUrl = "https://www.fonvirtual.com/en/wp-content/uploads/2020/03/telecommuting-opt.jpg",
                tag = "Backend"
            )
        }
        item {
            PersonCard(
                title = "Кутакбах",
                imageUrl = "https://www.fonvirtual.com/en/wp-content/uploads/2020/03/telecommuting-opt.jpg",
                tag = "Developer"
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PersonCardLinePreview() {
    MyMeetingAppTheme {
        PersonCardline()
    }
}