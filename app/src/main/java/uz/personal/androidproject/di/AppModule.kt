package uz.personal.androidproject.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import uz.personal.data.local.RoomDaoInterface
import uz.personal.data.local.appDatabase.AppDatabase
import uz.personal.data.remote.ApiInterface
import uz.personal.data.remote.retrofitBuilder.RetrofitBuilder
import uz.personal.data.repository.NetworkRepositoryIml
import uz.personal.data.repository.RepositoryController
import uz.personal.data.repository.RoomRepositoryIml
import uz.personal.domain.repository.RetrofitRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    //room
    @Provides
    @Singleton
    fun provideRoomStorage(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.getDataDB(context = context)
    }

    @Singleton
    @Provides
    fun getDao(appDB: AppDatabase): RoomDaoInterface {
        return appDB.dao()
    }

    @Singleton
    @Provides
    fun provideRoomRepositoryIml(roomDaoInterface: RoomDaoInterface):RoomRepositoryIml {
        return RoomRepositoryIml(roomDaoInterface = roomDaoInterface)
    }

    @Singleton
    @Provides
    fun provideRetrofitRepositoryIml(apiInterface: ApiInterface):NetworkRepositoryIml {
        return NetworkRepositoryIml(apiInterface = apiInterface)
    }



    @Provides
    @Singleton
    fun provideRetrofitGetServer(): ApiInterface {
        return RetrofitBuilder.retrofitBuilder()
    }

    @Provides
    @Singleton
    fun provideRetrofitRepository(
        networkRepositoryIml: NetworkRepositoryIml,
        roomRepositoryIml: RoomRepositoryIml
    ): RetrofitRepository {
        return RepositoryController(
            networkRepositoryIml = networkRepositoryIml,
            roomRepositoryIml = roomRepositoryIml
        )
    }
}