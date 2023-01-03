package com.example.grandtask.presentation.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.grandtask.data.model.images.Image
import com.example.grandtask.data.util.Resource
import com.example.grandtask.domain.useCase.GetImagesDataUseCase
import com.example.grandtask.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ImagesViewModel @Inject constructor ( private val getImagesDataUseCase: GetImagesDataUseCase) :BaseViewModel() {

    private val getImagesMutableLiveData = MutableLiveData<Resource<List<Image>>>()


    fun getImages(albumID:Int):LiveData<Resource<List<Image>>>{

        viewModelScope.launch(Dispatchers.IO) {

                getImagesMutableLiveData.postValue(Resource.Loading())
                try {
                    val images = getImagesDataUseCase.execute(albumID)
                    getImagesMutableLiveData.postValue(images)
                }catch (e:Exception){
                    Log.d("error image viewmodel", "getImages: ${e.message}")
                    getImagesMutableLiveData.postValue(Resource.Error("${e.message}"))
                }


        }


        return getImagesMutableLiveData
    }
}