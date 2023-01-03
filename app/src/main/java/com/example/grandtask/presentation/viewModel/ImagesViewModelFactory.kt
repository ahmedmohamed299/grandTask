package com.example.grandtask.presentation.viewModel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.grandtask.domain.useCase.GetImagesDataUseCase

class ImagesViewModelFactory(val app: Application, private val getImagesDataUseCase: GetImagesDataUseCase) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ImagesViewModel( getImagesDataUseCase) as T
    }
}