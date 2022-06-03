package com.example.grandtask.presentation.viewModel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.grandtask.data.model.images.Image
import com.example.grandtask.data.util.Resource
import com.example.grandtask.domain.useCase.GetImagesDataUseCase
import com.example.grandtask.presentation.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ImagesViewModel(private val app:Application , private val getImagesDataUseCase: GetImagesDataUseCase) :BaseViewModel() {

    private val getImagesMutableLiveData = MutableLiveData<Resource<List<Image>>>()


    fun getImages(albumID:Int):LiveData<Resource<List<Image>>>{

        viewModelScope.launch(Dispatchers.IO) {
            if (isNetworkAvailable(app))
            {
                getImagesMutableLiveData.postValue(Resource.Loading())

                val images = getImagesDataUseCase.execute(albumID)
                getImagesMutableLiveData.postValue(images)
            }else{
                getImagesMutableLiveData.postValue(Resource.Error("No Internet Connection"))
            }
        }


        return getImagesMutableLiveData
    }
}