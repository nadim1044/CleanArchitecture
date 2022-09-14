package com.example.demoarchitecture.presentaion.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.example.demoarchitecture.BuildConfig
import com.example.demoarchitecture.data.PreferenceManager
import com.example.demoarchitecture.data.api.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {

    //ToDO Base Url need to add
    @Provides
    fun provideBaseUrl() = "https://reqres.in/api/"

    @Provides
    @Singleton
    fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    } else OkHttpClient
        .Builder()
        .build()

    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        BASE_URL: String
    ): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

    @Provides
    @Singleton
    fun provideSharedPreference(context: Application): SharedPreferences =
        context.getSharedPreferences("app", Context.MODE_PRIVATE)

    @Provides
    @Singleton
    fun providePreferenceManager(sharedPreference: SharedPreferences): PreferenceManager =
        PreferenceManager(sharedPreferences = sharedPreference)

}