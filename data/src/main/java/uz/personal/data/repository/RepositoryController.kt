package uz.personal.data.repository

import android.content.ContentValues.TAG
import android.util.Log
import uz.personal.data.remote.responseUtils.Status
import uz.personal.domain.model.PostUseCaseData
import uz.personal.domain.model.UserPageData
import uz.personal.domain.model.UserPageDetailsData
import uz.personal.domain.repository.RetrofitRepository

class RepositoryController(
    val networkRepositoryIml: NetworkRepositoryIml, val roomRepositoryIml: RoomRepositoryIml
) : RetrofitRepository {

    override suspend fun getUserUseCase(): List<UserPageData> {
        val users = networkRepositoryIml.getUserUseCase()
        if (users.status == Status.SUCCESS) {
            users.data?.let { data ->
                roomRepositoryIml.insertUsers(data)
            }
        }

        return roomRepositoryIml.getUsers()
    }

    override suspend fun getPostUseCase(): List<PostUseCaseData> {
        val posts = networkRepositoryIml.getPostUseCase()
        if (posts.status == Status.SUCCESS) {
            posts.data?.let {
                roomRepositoryIml.insertPost(it)
            }
        }
        return roomRepositoryIml.getPost()
    }

    override suspend fun getUserById(userId: Int): UserPageDetailsData {
        val userDataLocal = roomRepositoryIml.getUserById(userId)

        return UserPageDetailsData(
            id = userDataLocal.id,
            name = userDataLocal.name,
            userName = userDataLocal.username,
            phone = userDataLocal.phone,
            email = userDataLocal.email
        )
    }
}