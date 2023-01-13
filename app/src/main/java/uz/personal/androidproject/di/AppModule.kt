package uz.personal.androidproject.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.personal.data.remote.ApiInterface
import uz.personal.data.remote.retrofitBuilder.RetrofitBuilder
import uz.personal.data.repository.NetworkRepositoryIml
import uz.personal.domain.repository.RetrofitRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofitGetServer(): ApiInterface {
        return RetrofitBuilder.retrofitBuilder()
    }

    @Provides
    @Singleton
    fun provideRetrofitRepository(apiInterface: ApiInterface): RetrofitRepository {
        return NetworkRepositoryIml(apiInterface = apiInterface)
    }
}