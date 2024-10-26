package com.example.newUiKit.NewMolecules

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import com.example.models.UserData
import com.example.newUiKit.newTheme.MyMeetingAppTheme
import com.example.newUiKit.newTheme.MyUiTheme

const val MAX_VISIBLE_AVATARS = 5

@Composable
fun AvatarMembersRow(avatarPainters: List<AsyncImagePainter>, modifier: Modifier = Modifier) {
    val maxVisibleAvatars = MAX_VISIBLE_AVATARS
    val displayedAvatars = avatarPainters.take(maxVisibleAvatars)


    Row(
        modifier = modifier
            .background(Color.Transparent),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy((-14).dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            displayedAvatars.forEachIndexed { index, painter ->
                Image(
                    painter = painter,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(56.dp)
                        .clip(CircleShape)
                        .zIndex((maxVisibleAvatars - index).toFloat())
                )
            }

            // Счетчик невошедших
            if (avatarPainters.size > maxVisibleAvatars) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape)
                        .background(color = MyUiTheme.colors.newOffWhite)
                        .border(Dp(2F), color = Color.White, shape = CircleShape)
                        .zIndex((maxVisibleAvatars + MAX_VISIBLE_AVATARS).toFloat())
                ) {
                    Text(
                        text = "+${avatarPainters.size - maxVisibleAvatars}",
                        style = MyUiTheme.typography.Secondary.copy(color = MyUiTheme.colors.newBrandDefault),
                    )
                }
            }
        }
    }
}

val users = listOf(
    UserData(
        title = "Мария",
        painter = "https://people.com/thmb/yivXS08TvhHbTBuDf5qXGltsioE=/4000x0/filters:no_upscale():max_bytes(150000):strip_icc():focal(599x0:601x2)/TaylorSwift_PEOPLE_2-3ae7b9b0cfee4c869253ec38306a5ead.jpg",
        tag = "Developer"
    ),

    UserData(
        title = "Андрей",
        painter = "https://images.squarespace-cdn.com/content/v1/656f4e4dababbd7c042c4946/82bec838-05c8-4d68-b173-2284a6ad4e52/how-to-stop-being-a-people-pleaser",
        tag = "Developer"
    ),

    UserData(
        title = "Ирина",
        painter = "https://people.com/thmb/CmROfB5Fw4H3oJmGwr7qJTGDCGg=/4000x0/filters:no_upscale():max_bytes(150000):strip_icc():focal(509x0:511x2)/people-headshot-lindsay-kimble-9855440283c440159d1684a4befaa97d.jpg",
        tag = "Design"
    ),
    UserData(
        title = "Николай",
        painter = "https://townsquare.media/site/366/files/2022/02/attachment-oli_sykes_bmth_2022_red_carpet_photo.jpg",
        tag = "Design"
    ),

    UserData(
        title = "Егор",
        painter = "https://upload.wikimedia.org/wikipedia/en/3/31/Punk_Rock_GG_Allin.jpg",
        tag = "Тестирование"
    ),

    UserData(
        title = "Саша",
        painter = "https://static.78.ru/images/uploads/1709489852416.jpg",
        tag = "Developer"
    ),
    UserData(
        title = "Ксюша",
        painter = "https://i1.sndcdn.com/artworks-lzx5vbAFjpYR1MKh-nAE8ww-t500x500.jpg",
        tag = "Developer"
    ),

    UserData(
        title = "Ашот",
        painter = "https://dota2.ru/img/news/slider/t1727192627.webp",
        tag = "Backend"
    ),

    UserData(
        title = "Илья",
        painter = "https://i.scdn.co/image/ab67616d0000b2738ed8f4c0c3642353767a5b9a",
        tag = "Design"
    ),

    UserData(
        title = "Егор",
        painter = "https://i1.sndcdn.com/artworks-000395381907-hh0kri-t500x500.jpg",
        tag = "Design"
    ),

    UserData(
        title = "Саша",
        painter = "https://i.discogs.com/-XgaXSEOpfCAdfpoSKTlXJ5HCtAUuDu_zNXN-iSyFMo/rs:fit/g:sm/q:40/h:300/w:300/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTI0NTYy/ODk1LTE2NjM1ODY4/MTUtOTUzMC5qcGVn.jpeg",
        tag = "Developer"
    ),
    UserData(
        title = "Ксюша",
        painter = "https://steamuserimages-a.akamaihd.net/ugc/954095759586959741/5EBE100FD5AB473DBCE04280D14CAC8B1ABE5753/",
        tag = "Design"
    ),

    UserData(
        title = "Ашот",
        painter = "https://www.fonvirtual.com/en/wp-content/uploads/2020/03/telecommuting-opt.jpg",
        tag = "Backend"
    ),


    )

@Preview(showBackground = true)
@Composable
fun PreviewAvatarRows() {
    MyMeetingAppTheme {
        val avatarPainters = users.map { user ->
            rememberAsyncImagePainter(model = user.painter)
        }
        AvatarMembersRow(
            avatarPainters = avatarPainters
        )

    }
}