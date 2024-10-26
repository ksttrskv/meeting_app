package com.example.newUiKit.newScreens.Repo

import com.example.models.UserData

class UserRepositoryImpl : UserRepository {
    override fun getUsers(): List<UserData> {
        return listOf(
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
    }
}