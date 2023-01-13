package uz.personal.data.remote

import retrofit2.Response
import retrofit2.http.GET
import uz.personal.data.remote.model.post.Post
import uz.personal.data.remote.model.users.Users

interface ApiInterface {
    @GET("users")
    suspend fun user(): Response<Users>

    @GET("posts")
    suspend fun post(): Response<Post>
}