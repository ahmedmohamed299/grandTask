package com.example.grandtask.data.repository.images.dataSourceImpl

import com.example.grandtask.data.api.APIsService
import com.example.grandtask.data.model.images.Image
import com.example.grandtask.data.repository.images.dataSource.ImagesDataSource
import retrofit2.Response

class ImagesDataSourceImpl(val apIsService: APIsService):ImagesDataSource {
    override suspend fun getImages(albumId: Int): Response<List<Image>> {
        return apIsService.getAllPhotos(albumId)
    }
}