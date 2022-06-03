package com.example.grandtask.presentation.viewModel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.grandtask.domain.useCase.GetAlbumUseCase
import com.example.grandtask.domain.useCase.GetUserDataUseCase

class HomeViewModelFactory(
    private val app: Application,
    private val getUserDataUseCase: GetUserDataUseCase,
    private val getAlbumUseCase: GetAlbumUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return HomeViewModel(app, getUserDataUseCase,getAlbumUseCase) as T
    }
}
