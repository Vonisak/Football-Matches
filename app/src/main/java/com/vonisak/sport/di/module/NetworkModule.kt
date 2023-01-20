package com.vonisak.sport.di.module

import com.vonisak.sport.data.network.SportApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {

    private companion object {

        const val BASE_URL = "https://app.sportdataapi.com/api/v1/"
    }

    @Provides
    fun provideBaseUrl(): String =
        BASE_URL

    @Provides
    fun provideGsonConverterFactory(): GsonConverterFactory =
        GsonConverterFactory.create()

    @Provides
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient().newBuilder().addInterceptor {
        val request =
            it.request().newBuilder().addHeader("apikey", "5544bc80-97e9-11ed-9ee1-df424d704456")
                .build()
        it.proceed(request)
    }.build()

    @Provides
    fun provideRetrofit(
        gsonConverterFactory: GsonConverterFactory,
        baseUrl: String,
        client: OkHttpClient
    ): Retrofit =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(gsonConverterFactory)
            .client(client)
            .build()

    @Provides
    fun provideRetrofitSportApi(retrofit: Retrofit): SportApi = retrofit.create(
        SportApi::class.java
    )
}