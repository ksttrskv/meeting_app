package com.example.newUiKit.newScreens.EventDetailScreen


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.newUiKit.Tags.MediumTagsList
import com.example.newUiKit.newTheme.MyUiTheme
import com.example.wbtechnoschoollesson2.R
import com.example.wbtechnoschoollesson2.atoms.theme.WBTechnoschoolLesson2Theme

@Composable
fun EventDetailCard(
    eventTitle: String,
    textStyle: TextStyle = MyUiTheme.typography.H1,
//    imageUrl: String,
    painter: Painter,
    date: String,
    location: String,
    modifier: Modifier = Modifier
) {
    val tags = listOf(
        "Backend", "Тестирование", "Разработка"
    )
    Card(

        colors = CardDefaults.cardColors(Color.Transparent),
        modifier = modifier
    ) {

        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Image(
//                        painter = rememberAsyncImagePainter(imageUrl),
                painter = painter,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .size(267.dp)
                    .clip(RoundedCornerShape(16.dp)),
                contentScale = ContentScale.Crop,
                alignment = Alignment.TopStart
            )
            Column {
                Text(
                    text = eventTitle,
                    style = textStyle,
                    color = MyUiTheme.colors.newBlackColor
                )
                Text(
                    text = "$date · $location",
                    style = MyUiTheme.typography.Secondary,
                    color = MyUiTheme.colors.newSecondaryColor,
                )
                MediumTagsList(tags = tags)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewMeetingCard() {
    WBTechnoschoolLesson2Theme {
        EventDetailCard(
            eventTitle = "Python days",
//            imageUrl = "https://s3-alpha-sig.figma.com/img/5d33/6ebd/e64d2ae58f903a77264a0e3dc0191cfd?Expires=1725840000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=E30OTDKohz7oxCbx1Dfyao4i0gmlBNLiR7HR2zS05iN2d03GfeU8tsvm6x9ZAlJE~zyWcsrWliYiLVqLoALRP2PyKHpujsfo1BpOpYWcLKc8A8KvaIUoQdw8F6zm9EGZNWi7YBB2eRIoEXVF1mitXxc6S3IISIomeaJsDXZv8yGkwQodiFE~fJsmYRkio944LFqRWjFTZmFvYm5kgXttxRR6IMBOLNbZsggnC93~cdiGIXCvGc~rNpua2NLjnxrK0inq6DvfOJTVXOgRTrQRPfvvzhu8D4tyBN80jhOdVs-7YvsgrquPxlDckENmatUbXs99~eg5DducJspySyCbxg__",
            painter = painterResource(id = R.drawable.pythondays),
            date = "10 августа",
            location = "Кожевенная линия, 40",
        )

    }
}