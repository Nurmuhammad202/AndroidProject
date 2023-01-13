package uz.personal.data.remote.retrofitBuilder

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uz.personal.data.remote.ApiInterface

object RetrofitBuilder {
    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

    fun retrofitBuilder(): ApiInterface {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(ApiInterface::class.java)
    }
}