package com.codelap.waglegamoon.di

import com.codelap.waglegamoon.data.datasource.post.HomeDataSource
import com.codelap.waglegamoon.data.datasource.post.HomeRepositoryImpl
import com.codelap.waglegamoon.data.datasource.user.UserDataSource
import com.codelap.waglegamoon.data.datasource.user.UserRepositoryImpl
import com.codelap.waglegamoon.domain.repository.HomeRepository
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

    @Singleton
    @Provides
    fun provideHomeRepository(homeDataSource: HomeDataSource): HomeRepository = HomeRepositoryImpl(homeDataSource)
}