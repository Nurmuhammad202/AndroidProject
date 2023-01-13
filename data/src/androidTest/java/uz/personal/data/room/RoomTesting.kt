package uz.personal.data.room

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.runner.RunWith
import uz.personal.data.local.RoomDaoInterface
import uz.personal.data.local.appDatabase.AppDatabase
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import kotlinx.coroutines.flow.collect
import org.junit.*
import uz.personal.data.local.models.post.PostModelItemLocal
import uz.personal.data.local.models.user.AddressLocal
import uz.personal.data.local.models.user.CompanyLocal
import uz.personal.data.local.models.user.GeoLocal
import uz.personal.data.local.models.user.UsersItemLocal

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@SmallTest
class RoomTesting {
    //for live date
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()


    lateinit var quoteDatabase: AppDatabase
    lateinit var quoteDao: RoomDaoInterface

    @Before
    fun setup() {
        quoteDatabase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext<Context?>().applicationContext,
            AppDatabase::class.java
        ).allowMainThreadQueries().build()


        quoteDao = quoteDatabase.dao()
    }

    @After
    fun tearDown() {
        quoteDatabase.close()
    }

    @Test
    fun saveUserItem() = runBlocking {
        val usersItemLocal = UsersItemLocal(
            0,
            AddressLocal("", GeoLocal("", ""), "", "", ""),
            CompanyLocal("0", "", ""),
            "@gmail",
            "Nur",
            "+998",
            "Yul",
            "www.google.com"
        )
        val listUser = ArrayList<UsersItemLocal>()
        listUser.add(usersItemLocal)
        quoteDao.insertAllUser(listUser)


        var response = ""
        quoteDao.getUserItem().collect {
            response = it[0].name
        }

        Assert.assertEquals(response, usersItemLocal.name)
    }

    @Test
    fun getPost() = runBlocking {
        val post = PostModelItemLocal("", 0, "title", 1)
        var response = ""
        val list=ArrayList<PostModelItemLocal>()
        list.add(post)
        quoteDao.insertAllPosts(list)

        quoteDao.getPosts().collect {
            response = it[0].title
        }
        Assert.assertEquals(response, post.title)
    }
}