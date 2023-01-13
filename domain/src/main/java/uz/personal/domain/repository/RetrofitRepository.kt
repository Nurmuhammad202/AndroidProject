package uz.personal.domain.repository

import uz.personal.domain.model.PostUseCaseData
import uz.personal.domain.model.UserPageData
import uz.personal.domain.model.UserPageDetailsData

interface RetrofitRepository {

    suspend fun getUserUseCase(): List<UserPageData>

    suspend fun getPostUseCase(): List<PostUseCaseData>

    suspend fun getUserById(userId: Int): UserPageDetailsData
}