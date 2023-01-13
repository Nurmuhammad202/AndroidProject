package uz.personal.domain.usecase

import uz.personal.domain.model.PostUseCaseData
import uz.personal.domain.repository.RetrofitRepository

class PostUseCase(private val retrofitRepository: RetrofitRepository) {
    suspend fun execute(): List<PostUseCaseData> {
        return retrofitRepository.getPostUseCase()
    }
}