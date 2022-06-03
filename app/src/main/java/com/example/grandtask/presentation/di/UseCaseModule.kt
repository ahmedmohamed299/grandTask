package com.example.grandtask.presentation.di

import com.example.grandtask.domain.repository.AlbumRepository
import com.example.grandtask.domain.repository.ImagesRepository
import com.example.grandtask.domain.repository.UseRepository
import com.example.grandtask.domain.useCase.GetAlbumUseCase
import com.example.grandtask.domain.useCase.GetImagesDataUseCase
import com.example.grandtask.domain.useCase.GetUserDataUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class UseCaseModule {

    @Provides
    fun provideGetUserDataUseCase(useRepository: UseRepository): GetUserDataUseCase {
        return GetUserDataUseCase(useRepository)
    }
    @Provides
    fun provideGetUserAlbumDataUseCase(albumRepository: AlbumRepository): GetAlbumUseCase {
        return GetAlbumUseCase(albumRepository)
    }
    @Provides
    fun provideGetImagesUseCase(imagesRepository: ImagesRepository): GetImagesDataUseCase {
        return GetImagesDataUseCase(imagesRepository)
    }
}