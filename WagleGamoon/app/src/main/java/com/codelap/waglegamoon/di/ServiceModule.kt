package com.codelap.waglegamoon.di

import com.codelap.waglegamoon.data.remote.GamoonService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Provides
    @Singleton
    fun provideLoginService(
        @NetworkModule.GamoonInterceptorOkHttpClient retrofit: Retrofit
    ): GamoonService = retrofit.create(GamoonService::class.java)
}