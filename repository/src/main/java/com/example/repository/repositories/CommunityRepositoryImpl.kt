//package com.example.repository.repositories
//
//import com.example.domain.model.Community
//import com.example.domain.repository.CommunityRepository
//
//class CommunityRepositoryImpl : CommunityRepository {
//
//    override suspend fun getAllCommunities(): List<Community> {
//        // Здесь можно загрузить данные о сообществах из сети, БД или другого источника
//        return listOf(
//            Community("Designa", "10 000 человек", R.drawable.communityavatar),
//            Community("Designa", "10 000 человек", R.drawable.communityavatar),
//            Community("Designa", "10 000 человек", R.drawable.communityavatar),
//            Community("Designa", "10 000 человек", R.drawable.communityavatar),
//            Community("Designa", "10 000 человек", R.drawable.communityavatar),
//            Community("Designa", "10 000 человек", R.drawable.communityavatar),
//            Community("Designa", "10 000 человек", R.drawable.communityavatar),
//            Community("Designa", "10 000 человек", R.drawable.communityavatar),
//            Community("Designa", "10 000 человек", R.drawable.communityavatar),
//            Community("Designa", "10 000 человек", R.drawable.communityavatar),
//            Community("Designa", "10 000 человек", R.drawable.communityavatar)
//        )
//    }
//}