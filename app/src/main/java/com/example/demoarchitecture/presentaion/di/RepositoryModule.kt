package com.example.demoarchitecture.presentaion.di

import com.example.demoarchitecture.data.PreferenceManager
import com.example.demoarchitecture.data.api.RemoteSource
import com.example.demoarchitecture.data.repository_imp.RepositoryImp
import com.example.demoarchitecture.domain.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideLoginRepository(
        service: RemoteSource,
        preferences: PreferenceManager
    ): Repository {
        return RepositoryImp(service, preferences)
    }

}