package com.example.grandtask.domain.useCase

import com.example.grandtask.data.model.images.Image
import com.example.grandtask.data.util.Resource
import com.example.grandtask.domain.repository.ImagesRepository

class GetImagesDataUseCase(private val imagesRepository: ImagesRepository) {
    suspend fun execute(albumId:Int):Resource<List<Image>>{
        return imagesRepository.getImages(albumId)
    }
}