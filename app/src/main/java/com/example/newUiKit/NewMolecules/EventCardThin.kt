package com.example.newUiKit.NewMolecules

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.newUiKit.Tags.SmallTag
import com.example.newUiKit.newTheme.MyUiTheme
import com.example.wbtechnoschoollesson2.R
import com.example.wbtechnoschoollesson2.atoms.theme.WBTechnoschoolLesson2Theme

@Composable
fun EventCardThin(
    title: String,
//    imageUrl: String,
    painter: Painter,
    date: String,
    location: String,
    isFinished: Boolean,
    onClick: () -> Unit
) {
    Card(
        onClick = onClick,
        modifier = Modifier.width(212.dp),
        colors = CardDefaults.cardColors(Color.Transparent)
    ) {

        Column {
            Image(
//                        painter = rememberAsyncImagePainter(imageUrl),
                painter = painterResource(id = R.drawable.pythondays),
                contentDescription = null,
                modifier = Modifier
                    .width(212.dp)
                    .clip(RoundedCornerShape(16.dp)),
                contentScale = ContentScale.Fit,
                alignment = Alignment.TopStart
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(
                    text = title,
                    style = MyUiTheme.typography.H3,
                    color = MyUiTheme.colors.newBlackColor
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "$date · $location",
                    style = MyUiTheme.typography.Secondary,
                    color = MyUiTheme.colors.newSecondaryColor,
                    modifier = Modifier.padding(end = 40.dp),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(8.dp))

                SmallTag(text = "Тестирование", isSelected = false, onSelectedChange = {})
//                    Spacer(modifier = Modifier.height(6.dp))
                SmallTag(text = "Тестирование", isSelected = false, onSelectedChange = {})

//                        Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewEventCardThin() {
    WBTechnoschoolLesson2Theme {
        EventCardThin(
            title = "Python days",
//            imageUrl = "https://s3-alpha-sig.figma.com/img/5d33/6ebd/e64d2ae58f903a77264a0e3dc0191cfd?Expires=1725840000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=E30OTDKohz7oxCbx1Dfyao4i0gmlBNLiR7HR2zS05iN2d03GfeU8tsvm6x9ZAlJE~zyWcsrWliYiLVqLoALRP2PyKHpujsfo1BpOpYWcLKc8A8KvaIUoQdw8F6zm9EGZNWi7YBB2eRIoEXVF1mitXxc6S3IISIomeaJsDXZv8yGkwQodiFE~fJsmYRkio944LFqRWjFTZmFvYm5kgXttxRR6IMBOLNbZsggnC93~cdiGIXCvGc~rNpua2NLjnxrK0inq6DvfOJTVXOgRTrQRPfvvzhu8D4tyBN80jhOdVs-7YvsgrquPxlDckENmatUbXs99~eg5DducJspySyCbxg__",
            painter = painterResource(id = R.drawable.pythondays),
            date = "10 августа",
            location = "Кожевенная линия, 40",
            isFinished = true,
            onClick = {})

    }
}