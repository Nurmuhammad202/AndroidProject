package uz.personal.domain.model

data class PostUseCaseData(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int,
)