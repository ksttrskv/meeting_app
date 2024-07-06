package com.example.wbtechnoschoollesson2.Molecules


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wbtechnoschoollesson2.R
import com.example.wbtechnoschoollesson2.atoms.theme.UiTheme
import com.example.wbtechnoschoollesson2.atoms.theme.WBTechnoschoolLesson2Theme


@Composable
fun CommunityCard(
    imageRes: Int,
    title: String,
    subtitle: String
) {
    Card(
        onClick = {},
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(Color.Transparent)
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .height(68.dp)
                .padding(bottom = 12.dp)
        ) {
            Column {
                Row {
                    Image(
                        painter = painterResource(id = imageRes),
                        contentDescription = null,
                        modifier = Modifier.size(48.dp),
                        contentScale = ContentScale.Crop,
                        alignment = Alignment.TopStart
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Column {
                        Text(
                            text = title,
                            style = UiTheme.typography.bodyText1,
                            color = UiTheme.colors.neutralActive,
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = subtitle,
                            style = UiTheme.typography.metadata1,
                            color = UiTheme.colors.neutralWeak,
                        )

                    }

                }

            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCommunityCard() {
    WBTechnoschoolLesson2Theme {
        CommunityCard(
            title = "Developer meeting",
            subtitle = "10 000 человек",
            imageRes = R.drawable.communityavatar,
        )
    }
}