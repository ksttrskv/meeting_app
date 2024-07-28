package com.example.domain.stubs

import com.example.domain.model.Community
import com.example.domain.usecases.interfaces.GetCommunityUseCase
import com.example.domain.usecases.interfaces.SaveCommunityUseCase
import com.example.domain.usecases.interfaces.UpdateCommunityUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetCommunityUseCaseStub : GetCommunityUseCase {
    override fun execute(): Flow<List<Community>> {
        return flow {
            emit(
                listOf(
                    Community("https://i.postimg.cc/GmsT4jPq/map-image.png","Designa", "10 000 человек"),
                    Community("https://i.postimg.cc/GmsT4jPq/map-image.png","Designa", "10 000 человек"),
                    Community("https://i.postimg.cc/GmsT4jPq/map-image.png","Designa", "16 000 человек"),
                    Community("https://i.postimg.cc/GmsT4jPq/map-image.png","Designa", "10 000 человек"),
                    Community("https://i.postimg.cc/GmsT4jPq/map-image.png","Designa", "12 000 человек"),
                    Community("https://i.postimg.cc/GmsT4jPq/map-image.png","Designa", "10 000 человек"),
                    Community("https://i.postimg.cc/GmsT4jPq/map-image.png","Designa", "10 000 человек"),
                    Community("https://i.postimg.cc/GmsT4jPq/map-image.png","Designa", "11 000 человек"),
                    Community("https://i.postimg.cc/GmsT4jPq/map-image.png","Designa", "10 000 человек")
                )
            )
        }
    }
}
class SaveCommunityUseCaseStub : SaveCommunityUseCase {
    override fun execute(community: Community): Flow<Boolean> {
        return flow {
            emit(true)
        }
    }
}

class UpdateCommunityUseCaseStub : UpdateCommunityUseCase {
    override fun execute(community: Community): Flow<Boolean> {
        return flow {
            emit(true)
        }
    }
}

