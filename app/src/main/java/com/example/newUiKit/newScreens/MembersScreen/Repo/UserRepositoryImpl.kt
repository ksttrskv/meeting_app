package com.example.newUiKit.newScreens.Repo

import com.example.newUiKit.newScreens.MembersScreen.UserData

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
        )
    }
}