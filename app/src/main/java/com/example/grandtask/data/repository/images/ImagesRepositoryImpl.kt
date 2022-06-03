package com.example.grandtask.data.repository.images

import com.example.grandtask.data.model.images.Image
import com.example.grandtask.data.repository.images.dataSource.ImagesDataSource
import com.example.grandtask.data.util.Resource
import com.example.grandtask.domain.repository.ImagesRepository

class ImagesRepositoryImpl(private val imagesDataSource: ImagesDataSource) :ImagesRepository{
    override suspend fun getImages(albumId: Int): Resource<List<Image>> {
        val response = imagesDataSource.getImages(albumId)
        return if (response.isSuccessful){
            Resource.Success(response.body()!!)
        }else{
            Resource.Error(response.message())
        }
    }
}