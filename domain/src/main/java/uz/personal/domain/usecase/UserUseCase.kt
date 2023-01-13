package uz.personal.domain.usecase

import uz.personal.domain.model.UserMainPage
import uz.personal.domain.repository.RetrofitRepository

class UserUseCase(private val retrofitRepository: RetrofitRepository) {
    suspend fun execute(): List<UserMainPage> {
        return retrofitRepository.getUserUseCase()
    }
}