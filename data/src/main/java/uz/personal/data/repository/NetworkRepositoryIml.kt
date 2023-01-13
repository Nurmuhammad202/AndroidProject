package uz.personal.data.repository

import uz.personal.data.remote.ApiInterface
import uz.personal.domain.model.PostUseCaseData
import uz.personal.domain.model.UserMainPage
import uz.personal.domain.repository.RetrofitRepository

class NetworkRepositoryIml(private val apiInterface: ApiInterface) : RetrofitRepository {

    override suspend fun getUserUseCase(): List<UserMainPage> {
        val list = mutableListOf<UserMainPage>()
        val response = apiInterface.user()
        if (response.isSuccessful && response.code() == 200) {
            response.body()?.let { users ->
                users.forEach { usersItem ->
                    list.add(UserMainPage(name = usersItem.name, username = usersItem.username))
                }
            }
        }
        return list
    }

    override suspend fun getPostUseCase(): List<PostUseCaseData> {
        val list = mutableListOf<PostUseCaseData>()
        val response = apiInterface.post()
        if (response.isSuccessful && response.code() == 200) {
            response.body()?.let { postModel ->
                postModel.forEach { postModelItem ->
                    list.add(PostUseCaseData(body = postModelItem.body,
                        id = postModelItem.id,
                        title = postModelItem.title,
                        userId = postModelItem.userId))
                }
            }
        }
        return list
    }
}