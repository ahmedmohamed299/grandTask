package com.example.grandtask.presentation.di

import com.example.grandtask.data.api.APIsService
import com.example.grandtask.data.db.UserDao
import com.example.grandtask.data.repository.user.dataSource.UserLocalDataSource
import com.example.grandtask.data.repository.user.dataSource.UserRemoteDataSource
import com.example.grandtask.data.repository.user.dataSourceImpl.UserLocalDataSourceImpl
import com.example.grandtask.data.repository.user.dataSourceImpl.UserRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class LocalDataModule{
    @Singleton
    @Provides
    fun provideUserLocalDataSource(
        userDao: UserDao
    ): UserLocalDataSource {
        return UserLocalDataSourceImpl(userDao)
    }
}