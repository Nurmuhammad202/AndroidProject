package uz.personal.androidproject.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import uz.personal.domain.repository.RetrofitRepository
import uz.personal.domain.usecase.PostUseCase
import uz.personal.domain.usecase.UserInfoUseCase
import uz.personal.domain.usecase.UserUseCase

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {

    @Provides
    fun provideUserCase(retrofitRepository: RetrofitRepository): UserUseCase {
        return UserUseCase(retrofitRepository = retrofitRepository)
    }

    @Provides
    fun providePostUseCase(retrofitRepository: RetrofitRepository): PostUseCase {
        return PostUseCase(retrofitRepository = retrofitRepository)
    }


    @Provides
    fun provideUserInfo(retrofitRepository: RetrofitRepository): UserInfoUseCase {
        return UserInfoUseCase(retrofitRepository = retrofitRepository)
    }

}