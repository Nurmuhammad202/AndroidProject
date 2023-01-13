package uz.personal.androidproject.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import uz.personal.domain.repository.RetrofitRepository
import uz.personal.domain.usecase.PostUseCase

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {


    @Provides
    fun provideUserNameUseCase(userRepository: RetrofitRepository): PostUseCase {
        return PostUseCase(retrofitRepository = userRepository)
    }
}