package uz.personal.domain.faceRepository

import uz.personal.domain.model.PostUseCaseData
import uz.personal.domain.model.UserMainPage
import uz.personal.domain.repository.RetrofitRepository

class FaceRepository : RetrofitRepository {
    override suspend fun getUserUseCase(): List<UserMainPage> {
        val list = mutableListOf<UserMainPage>()
        list.add(UserMainPage(name = "Leanne Graham", username = "Leanne Graham"))
        return list
    }

    override suspend fun getPostUseCase(): List<PostUseCaseData> {
        return mutableListOf()
    }
}