package com.example.grandtask.presentation.viewModel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.grandtask.data.model.album.Album

import com.example.grandtask.data.model.user.Users
import com.example.grandtask.data.util.Resource
import com.example.grandtask.domain.useCase.GetAlbumUseCase
import com.example.grandtask.domain.useCase.GetUserDataUseCase
import com.example.grandtask.presentation.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(
    private val app: Application,
    private val getUserDataUseCase: GetUserDataUseCase,
    private val getAlbumUseCase: GetAlbumUseCase
) :
    BaseViewModel() {


    private var getUserMutableLiveData = MutableLiveData<Resource<Users>>()
    private var getAlbumMutableLiveData = MutableLiveData<Resource<List<Album>>>()


    fun getUser(): LiveData<Resource<Users>> {

        viewModelScope.launch(Dispatchers.IO) {
            getUserMutableLiveData.postValue(Resource.Loading())
            if (isNetworkAvailable(app)) {
                val user = getUserDataUseCase.execute()
                getUserMutableLiveData.postValue(user)
            } else {
                getUserMutableLiveData.postValue(Resource.Error("No Internet Connection"))
            }

        }



        return getUserMutableLiveData
    }

    fun getAlbum(userId:Int):LiveData<Resource<List<Album>>>{


            viewModelScope.launch(Dispatchers.IO) {
                if (isNetworkAvailable(app)){
                getAlbumMutableLiveData.postValue(Resource.Loading())
                val album = getAlbumUseCase.execute(userId)
                getAlbumMutableLiveData.postValue(album)

            }else{
                getAlbumMutableLiveData.postValue(Resource.Error("No internet Connection"))
                }
        }



        return getAlbumMutableLiveData
    }
}