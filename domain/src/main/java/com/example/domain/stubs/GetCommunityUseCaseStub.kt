//package com.example.domain.stubs
//
//import com.example.domain.model.Community
//import com.example.domain.usecases.interfaces.GetCommunityUseCase
//import com.example.domain.usecases.interfaces.SaveCommunityUseCase
//import com.example.domain.usecases.interfaces.UpdateCommunityUseCase
//import kotlinx.coroutines.flow.Flow
//import kotlinx.coroutines.flow.flow
//
//class GetCommunityUseCaseStub : GetCommunityUseCase {
//    override fun execute(): Flow<List<Community>> {
//        return flow {
//            emit(
//                List(10) {
//                    Community("https://ae04.alicdn.com/kf/H52a2dee501b94c5dadf148b8fbd9d9d79.jpg_640x640.jpg","Designa", "10 000 человек")
//                }
//
//            )
//        }
//    }
//}

//
//class SaveCommunityUseCaseStub : SaveCommunityUseCase {
//    override fun execute(community: Community): Flow<Boolean> {
//        return flow {
//            emit(true)
//        }
//    }
//}
//
//class UpdateCommunityUseCaseStub : UpdateCommunityUseCase {
//    override fun execute(community: Community): Flow<Boolean> {
//        return flow {
//            emit(true)
//        }
//    }
//}