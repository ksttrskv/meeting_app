package com.example.domain.stubs

import com.example.domain.model.Community
import com.example.domain.usecases.interfaces.GetCommunityUseCase
import com.example.domain.usecases.interfaces.SaveCommunityUseCase
import com.example.domain.usecases.interfaces.UpdateCommunityUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetCommunityUseCaseImpl : GetCommunityUseCase {
    override fun execute(): Flow<List<Community>> {
        return flow {
            emit(
                listOf(
                    Community(
                        "https://static.vecteezy.com/system/resources/previews/042/127/109/non_2x/round-tiktok-logo-with-thick-white-border-on-a-transparent-background-free-png.png",
                        "Designa",
                        "10 000 человек",
                    ),
                    Community(
                        "https://ae04.alicdn.com/kf/H52a2dee501b94c5dadf148b8fbd9d9d79.jpg_640x640.jpg",
                        "Designa",
                        "10 000 человек",
                    ),
                    Community(
                        "https://d3373sevsv1jc.cloudfront.net/uploads/communities_production/community/logo/12/03351916-7b62-4d43-b1ae-8a255219ebd8.jpg",
                        "Designa",
                        "10 000 человек",
                    ),
                    Community(
                        "https://storage.yandexcloud.net/incrussia-prod/wp-content/uploads/2022/06/Oblozhka-uzkogo-posta-copy-4.jpg",
                        "Designa",
                        "10 000 человек",
                    ),
                    Community(
                        "https://99designs-blog.imgix.net/blog/wp-content/uploads/2022/05/image10-3-e1659037365697.png?auto=format&q=60&fit=max&w=930",
                        "Designa",
                        "10 000 человек",
                    ),
                    Community(
                        "https://upload.wikimedia.org/wikipedia/commons/thumb/e/e5/NASA_logo.svg/1224px-NASA_logo.svg.png",
                        "Designa",
                        "10 000 человек",
                    ),
                    Community(
                        "https://forge.typo3.org/attachments/download/34180/logo.png",
                        "Designa",
                        "10 000 человек",
                    ),
                    Community(
                        "https://graphicdesignjunction.com/wp-content/uploads/2018/04/colorful_logo_1.jpg",
                        "Designa",
                        "10 000 человек",
                    ),
                    Community(
                        "https://static.vecteezy.com/system/resources/previews/042/127/109/non_2x/round-tiktok-logo-with-thick-white-border-on-a-transparent-background-free-png.png",
                        "Designa",
                        "10 000 человек",
                    ),
                    Community(
                        "https://ae04.alicdn.com/kf/H52a2dee501b94c5dadf148b8fbd9d9d79.jpg_640x640.jpg",
                        "Designa",
                        "10 000 человек",
                    ),
                    Community(
                        "https://d3373sevsv1jc.cloudfront.net/uploads/communities_production/community/logo/12/03351916-7b62-4d43-b1ae-8a255219ebd8.jpg",
                        "Designa",
                        "10 000 человек",
                    )
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