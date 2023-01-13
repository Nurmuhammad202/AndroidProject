package uz.personal.domain.repository

import uz.personal.domain.model.PostUseCaseData
import uz.personal.domain.model.UserMainPage

interface RetrofitRepository {

    suspend fun getUserUseCase(): List<UserMainPage>

    suspend fun getPostUseCase():List<PostUseCaseData>
}