package com.example.socialapp.di

import com.example.data.cloud.UserAnswerCloudDataSource
import com.example.data.cloud.UserAnswerCloudDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface CloudDataSourceModule {

    @Binds
    fun bingUserAuthRepository(
        impl: UserAnswerCloudDataSourceImpl,
    ): UserAnswerCloudDataSource

}