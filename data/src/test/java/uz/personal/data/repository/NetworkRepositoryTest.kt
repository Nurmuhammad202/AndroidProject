package uz.personal.data.repository

import kotlinx.coroutines.runBlocking
import org.junit.Assert

import org.junit.Before
import org.junit.Test
import uz.personal.data.repository.faceInterface.FaceApiInterfaceClass

class NetworkRepositoryTest {

    private lateinit var networkRepository: NetworkRepositoryIml

    @Before
    fun setUp() {
        networkRepository = NetworkRepositoryIml(FaceApiInterfaceClass())
    }

    @Test
    fun `repository user get`() = runBlocking {
        val response = networkRepository.getUserUseCase()
        Assert.assertEquals(response[0].name, "Leanne Graham")
    }

    @Test
    fun `repository post get`() = runBlocking {
        val response = networkRepository.getPostUseCase()
        Assert.assertEquals(response[0].id, 1)
    }
}