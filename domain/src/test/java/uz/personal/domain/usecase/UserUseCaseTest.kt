package uz.personal.domain.usecase

import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import uz.personal.domain.faceRepository.FaceRepository
import uz.personal.domain.model.UserPageData

class UserUseCaseTest {

    private lateinit var useCase: UserUseCase

    @Before
    fun setUp() {
        useCase = UserUseCase(FaceRepository())
    }

    @Test
    fun createData() = runBlocking {
        val data = UserPageData(name = "Leanne Graham", username = "Leanne Graham")
        val list = useCase.execute()
        Assert.assertEquals(data.name, list[0].name)
    }

    @Test
    fun algoritmic() {
        Assert.assertEquals(4, 2 + 2)
    }
}