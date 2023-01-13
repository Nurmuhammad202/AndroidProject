package uz.personal.data.repository.faceInterface

import retrofit2.Response
import uz.personal.data.remote.ApiInterface
import uz.personal.data.remote.model.*
import uz.personal.data.remote.model.post.PostModel
import uz.personal.data.remote.model.post.PostModelItem
import uz.personal.domain.model.UserMainPage

class FaceApiInterfaceClass : ApiInterface {
    override suspend fun user(): Response<Users> {
        val usersList = ArrayList<UsersItem>()
        usersList.add(UsersItem(
            Address("", Geo("", ""), "", "", ""),
            Company("", "", ""),
            "nurmuhammad@gmail.com",
            1,
            "Leanne Graham",
            "+998993018716",
            "Bret",
            ""))
        val users = Users()
        users.addAll(usersList)
        return Response.success(users)
    }

    override suspend fun post(): Response<PostModel> {
        val list = ArrayList<PostModelItem>()
        list.add(PostModelItem(
            body = "quia et suscipit nsuscipit recusandae consequuntur expedita et cumnreprehenderit molestiae ut ut quas totam nnostrum rerum est autem sunt rem eveniet architecto",
            id = 1,
            title = "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
            userId = 1))
        val postModel = PostModel()
        postModel.addAll(list)
        return Response.success(postModel)
    }
}