package com.example.domain.usecases.implementation

import com.example.domain.model.Community
import com.example.domain.usecases.interfaces.GetCommunityUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetCommunityUseCaseImpl : GetCommunityUseCase {
    override fun execute(): Flow<List<Community>> {
        return flow {
            emit(
                listOf(
                    Community("https://i.postimg.cc/GmsT4jPq/map-image.png","Designa", "10 000 человек", ),
                    Community("https://i.postimg.cc/GmsT4jPq/map-image.png","Designa", "10 000 человек", ),
                    Community("https://i.postimg.cc/GmsT4jPq/map-image.png","Designa", "10 000 человек", ),
                    Community("https://i.postimg.cc/GmsT4jPq/map-image.png","Designa", "10 000 человек", ),
                    Community("https://i.postimg.cc/GmsT4jPq/map-image.png","Designa", "10 000 человек", ),
                    Community("https://i.postimg.cc/GmsT4jPq/map-image.png","Designa", "10 000 человек", ),
                    Community("https://i.postimg.cc/GmsT4jPq/map-image.png","Designa", "10 000 человек", ),
                    Community("https://i.postimg.cc/GmsT4jPq/map-image.png","Designa", "10 000 человек", )

                )
            )
        }
    }
}