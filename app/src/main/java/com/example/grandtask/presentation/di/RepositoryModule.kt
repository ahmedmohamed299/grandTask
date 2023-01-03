package com.example.grandtask.presentation.di

import com.example.grandtask.data.repository.album.dataSource.AlbumDataSource
import com.example.grandtask.data.repository.images.ImagesRepositoryImpl
import com.example.grandtask.data.repository.images.dataSource.ImagesDataSource
import com.example.grandtask.data.repository.user.AlbumRepositoryImpl
import com.example.grandtask.data.repository.user.UserRepositoryImpl
import com.example.grandtask.data.repository.user.dataSource.UserLocalDataSource
import com.example.grandtask.data.repository.user.dataSource.UserRemoteDataSource
import com.example.grandtask.domain.repository.AlbumRepository
import com.example.grandtask.domain.repository.ImagesRepository
import com.example.grandtask.domain.repository.UseRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RepositoryModule {


    @Provides
    @Singleton
    fun provideUserRepository(
        userRemoteDataSource: UserRemoteDataSource
    ): UseRepository {

        return UserRepositoryImpl(
            userRemoteDataSource
        )
    }
    @Provides
    @Singleton
    fun provideAlbumRepository(
        albumDataSource: AlbumDataSource,
        userLocalDataSource: UserLocalDataSource
    ): AlbumRepository {

        return AlbumRepositoryImpl(
            albumDataSource,
            userLocalDataSource
        )
    }
    @Provides
    @Singleton
    fun provideImagesRepository(
        imagesDataSource: ImagesDataSource
    ): ImagesRepository {

        return ImagesRepositoryImpl(
            imagesDataSource
        )
    }




}