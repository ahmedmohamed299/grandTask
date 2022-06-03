package com.example.grandtask.presentation.di

import com.example.grandtask.data.api.APIsService
import com.example.grandtask.data.repository.album.dataSource.AlbumDataSource
import com.example.grandtask.data.repository.album.dataSourceImpl.AlbumDataSourceImpl
import com.example.grandtask.data.repository.images.dataSource.ImagesDataSource
import com.example.grandtask.data.repository.images.dataSourceImpl.ImagesDataSourceImpl
import com.example.grandtask.data.repository.user.dataSource.UserRemoteDataSource
import com.example.grandtask.data.repository.user.dataSourceImpl.UserRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RemoteDataModule {

    @Singleton
    @Provides
    fun provideUserRemoteDataSource(
        aPIService: APIsService
    ): UserRemoteDataSource {
        return UserRemoteDataSourceImpl(aPIService)
    }
    @Singleton
    @Provides
    fun provideAlbumRemoteDataSource(
        aPIService: APIsService
    ): AlbumDataSource {
        return AlbumDataSourceImpl(aPIService)
    }
    @Singleton
    @Provides
    fun provideImagesRemoteDataSource(
        aPIService: APIsService
    ): ImagesDataSource {
        return ImagesDataSourceImpl(aPIService)
    }


}