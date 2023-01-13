package uz.personal.domain.usecase

import uz.personal.domain.model.UserPageData
import uz.personal.domain.repository.RetrofitRepository

class UserUseCase(private val retrofitRepository: RetrofitRepository) {
    suspend fun execute(): List<UserPageData> {
        return retrofitRepository.getUserUseCase()
    }
}