package com.example.grandtask.presentation.di

import android.app.Application
import com.example.grandtask.domain.useCase.GetAlbumUseCase
import com.example.grandtask.domain.useCase.GetImagesDataUseCase
import com.example.grandtask.domain.useCase.GetUserDataUseCase
import com.example.grandtask.presentation.viewModel.HomeViewModelFactory
import com.example.grandtask.presentation.viewModel.ImagesViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FactoryModule {


    @Singleton
    @Provides
    fun provideUserViewModelFactory(
        app: Application,
       getUserDataUseCase: GetUserDataUseCase,
        getAlbumUseCase:GetAlbumUseCase
    ): HomeViewModelFactory {
        return HomeViewModelFactory(
            app,
            getUserDataUseCase,
            getAlbumUseCase
        )
    }
    @Singleton
    @Provides
    fun provideImagesViewModelFactory(
        app: Application,  getImagesDataUseCase: GetImagesDataUseCase
    ): ImagesViewModelFactory {
        return ImagesViewModelFactory(
            app,
            getImagesDataUseCase
        )
    }
}