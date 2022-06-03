package com.example.grandtask.data.repository.images.dataSource

import com.example.grandtask.data.model.images.Image
import retrofit2.Response

interface ImagesDataSource {
    suspend fun getImages(albumId:Int):Response<List<Image>>
}