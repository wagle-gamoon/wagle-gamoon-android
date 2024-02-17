package com.codelap.waglegamoon.di

import com.codelap.waglegamoon.data.datasource.UserDataSource
import com.codelap.waglegamoon.data.datasource.UserRepositoryImpl
import com.codelap.waglegamoon.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideUserRepository(userDataSource: UserDataSource): UserRepository = UserRepositoryImpl(userDataSource)
}