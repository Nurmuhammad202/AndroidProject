package uz.personal.data.local

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import kotlinx.coroutines.flow.Flow
import uz.personal.data.local.models.post.PostModelItemLocal
import uz.personal.data.local.models.user.UsersItemLocal

@Dao
interface RoomDaoInterface {

    @Insert(onConflict = REPLACE)
    suspend fun insertAllUser(list: List<UsersItemLocal>)

    @Insert(onConflict = REPLACE)
    suspend fun insertAllPosts(list: List<PostModelItemLocal>)

    @Query("SELECT * FROM UsersLocal")
    fun getUserItem(): List<UsersItemLocal>

    @Query("SELECT * FROM post_item")
    fun getPosts(): List<PostModelItemLocal>

    @Query("SELECT * FROM UsersLocal WHERE id=:userId")
    fun getUserById(userId: Int): UsersItemLocal
}