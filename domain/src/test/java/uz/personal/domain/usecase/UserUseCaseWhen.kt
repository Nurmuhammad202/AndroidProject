package uz.personal.domain.usecase

import org.junit.Before
import uz.personal.domain.faceRepository.FaceRepository

class UserUseCaseWhen {
    private lateinit var useCase: UserUseCase

    @Before
    fun setUp() {
        useCase = UserUseCase(FaceRepository())
    }


}