package uz.personal.data.repository

import retrofit2.Response
import uz.personal.data.remote.ApiInterface
import uz.personal.data.remote.model.post.Post
import uz.personal.data.remote.model.users.Users
import uz.personal.data.remote.responseUtils.NetworkHelper
import uz.personal.data.remote.responseUtils.Resource

class NetworkRepositoryIml(
    private val apiInterface: ApiInterface
) {

    suspend fun getUserUseCase(): Resource<Users> {
        if (NetworkHelper.internetHive()) {
            val response = apiInterface.user()
            if (responseType(response)) {
                response.body()?.let { users ->
                    return Resource.success(users)
                }
            }
        }
        return Resource.error("internet now", null)

    }

    suspend fun getPostUseCase(): Resource<Post> {
        if (NetworkHelper.internetHive()) {
            val response = apiInterface.post()
            if (responseType(response)) {
                response.body()?.let { postModel ->
                    return Resource.success(postModel)
                }
            }
        }
        return Resource.error("internet now", null)
    }


    private fun <T> responseType(response: Response<T>): Boolean {
        return response.isSuccessful && response.code() == 200
    }

}