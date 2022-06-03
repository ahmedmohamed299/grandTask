package com.example.grandtask.domain.repository

import com.example.grandtask.data.model.images.Image
import com.example.grandtask.data.util.Resource

interface ImagesRepository {

    suspend fun getImages(albumId:Int):Resource<List<Image>>
}