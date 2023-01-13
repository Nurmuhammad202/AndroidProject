package uz.personal.data.remote

import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import uz.personal.data.remote.model.Users
import uz.personal.data.remote.model.post.PostModel
import uz.personal.data.remote.retrofitBuilder.RetrofitBuilder

class RetrofitTesting {
    private lateinit var apiInterface: ApiInterface

    @Before
    fun setUp() {
        apiInterface = RetrofitBuilder.retrofitBuilder()
    }

    @Test
    fun `retrofit get user is working`() = runBlocking {
        var response = Users()
        apiInterface.user().body()?.let {
            response = it
        }
        Assert.assertEquals(response[0].name, "Leanne Graham")
    }

    @Test
    fun `retrofit get post is working`() = runBlocking {
        var responsePost = PostModel()
        apiInterface.post().body()?.let {
            responsePost = it
        }
        Assert.assertEquals(responsePost[0].id, 1)
    }

}