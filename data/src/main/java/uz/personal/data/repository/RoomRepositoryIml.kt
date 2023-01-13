package uz.personal.data.repository

import android.content.ContentValues.TAG
import android.util.Log
import uz.personal.data.local.RoomDaoInterface
import uz.personal.data.local.models.post.PostModelItemLocal
import uz.personal.data.local.models.user.AddressLocal
import uz.personal.data.local.models.user.CompanyLocal
import uz.personal.data.local.models.user.GeoLocal
import uz.personal.data.local.models.user.UsersItemLocal
import uz.personal.data.remote.model.post.Post
import uz.personal.data.remote.model.users.Users
import uz.personal.domain.model.PostUseCaseData
import uz.personal.domain.model.UserPageData

class RoomRepositoryIml(private val roomDaoInterface: RoomDaoInterface) {

    suspend fun insertUsers(list: Users) {

        val userList = ArrayList<UsersItemLocal>()

        list.forEach { usersItem ->
            val userLocal = UsersItemLocal(
                id = usersItem.id,
                AddressLocal(
                    city = usersItem.address.city,
                    geo = GeoLocal(
                        lat = usersItem.address.geo.lat, lng = usersItem.address.geo.lng
                    ),
                    street = usersItem.address.street,
                    suite = usersItem.address.suite,
                    zipcode = usersItem.address.zipcode,
                ),
                CompanyLocal(
                    bs = usersItem.company.bs,
                    catchPhrase = usersItem.company.catchPhrase,
                    nameCompany = usersItem.company.name
                ),
                email = usersItem.email,
                name = usersItem.name,
                phone = usersItem.phone,
                username = usersItem.username,
                website = usersItem.website
            )
            userList.add(userLocal)
        }

        roomDaoInterface.insertAllUser(userList)

    }

    suspend fun insertPost(list: Post) {
        val postLocals = ArrayList<PostModelItemLocal>()

        list.forEach { postItem ->
            val data = PostModelItemLocal(
                body = postItem.body,
                title = postItem.title,
                id = postItem.id,
                userId = postItem.userId
            )
            postLocals.add(data)
        }

        roomDaoInterface.insertAllPosts(postLocals)
    }

    fun getPost(): List<PostUseCaseData> {
        val listResponse = ArrayList<PostUseCaseData>()
        roomDaoInterface.getPosts().forEach {
            listResponse.add(
                PostUseCaseData(
                    body = it.body, id = it.id, title = it.title, userId = it.userId
                )
            )
        }
        return listResponse
    }

    fun getUsers(): List<UserPageData> {
        val listResponse = ArrayList<UserPageData>()
        roomDaoInterface.getUserItem().forEach {
            listResponse.add(
                UserPageData(
                    userId = it.id, name = it.name, username = it.username
                )
            )
        }
        Log.d(TAG, "getUsers: asdsdas${listResponse.size}")
        return listResponse
    }

    fun getUserById(id: Int): UsersItemLocal {
        return roomDaoInterface.getUserById(id)
    }
}