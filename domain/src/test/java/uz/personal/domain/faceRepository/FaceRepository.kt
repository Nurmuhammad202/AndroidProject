package uz.personal.domain.faceRepository

import uz.personal.domain.model.PostUseCaseData
import uz.personal.domain.model.UserPageData
import uz.personal.domain.repository.RetrofitRepository

class FaceRepository : RetrofitRepository {
    override suspend fun getUserUseCase(): List<UserPageData> {
        val list = mutableListOf<UserPageData>()
        list.add(UserPageData(name = "Leanne Graham", username = "Leanne Graham"))
        return list
    }

    override suspend fun getPostUseCase(): List<PostUseCaseData> {
        return mutableListOf()
    }
}