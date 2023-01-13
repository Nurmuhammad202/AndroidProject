package uz.personal.domain.usecase

import uz.personal.domain.model.PostUseCaseData
import uz.personal.domain.repository.RetrofitRepository

class PostUseCase(private val retrofitRepository: RetrofitRepository) {
    suspend fun execute(userId: Int): List<PostUseCaseData> {
        val responseList = retrofitRepository.getPostUseCase()
        val list = ArrayList<PostUseCaseData>()
        responseList.forEach { postUseCaseData: PostUseCaseData ->
            if (postUseCaseData.userId == userId) {
                list.add(postUseCaseData)
            }
        }
        return list
    }
}