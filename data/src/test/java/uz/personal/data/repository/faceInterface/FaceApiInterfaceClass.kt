package uz.personal.data.repository.faceInterface

import retrofit2.Response
import uz.personal.data.remote.ApiInterface
import uz.personal.data.local.models.post.PostModelItemLocal
import uz.personal.data.remote.model.users.*

class FaceApiInterfaceClass : ApiInterface {
    override suspend fun user(): Response<Users> {
        val usersList = ArrayList<UsersItem>()
        usersList.add(
            UsersItem(
            Address("", Geo("", ""), "", "", ""),
            Company("", "", ""),
            "nurmuhammad@gmail.com",
            1,
            "Leanne Graham",
            "+998993018716",
            "Bret",
            "")
        )
        val users = Users()
        users.addAll(usersList)
        return Response.success(users)
    }

    override suspend fun post(): Response<PostModelLocal> {
        val list = ArrayList<PostModelItemLocal>()
        list.add(
            PostModelItemLocal(
            body = "quia et suscipit nsuscipit recusandae consequuntur expedita et cumnreprehenderit molestiae ut ut quas totam nnostrum rerum est autem sunt rem eveniet architecto",
            id = 1,
            title = "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
            userId = 1)
        )
        val postModel = PostModelLocal()
        postModel.addAll(list)
        return Response.success(postModel)
    }
}