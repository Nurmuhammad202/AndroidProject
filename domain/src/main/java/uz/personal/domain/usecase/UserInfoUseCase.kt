package uz.personal.domain.usecase

import uz.personal.domain.model.UserPageDetailsData
import uz.personal.domain.repository.RetrofitRepository

class UserInfoUseCase(private val retrofitRepository: RetrofitRepository) {
    suspend fun execute(userId: Int): UserPageDetailsData {
        return retrofitRepository.getUserById(userId)
    }
}