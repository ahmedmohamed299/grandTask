package com.example.grandtask.domain.useCase

import com.example.grandtask.data.model.album.Album
import com.example.grandtask.data.util.Resource
import com.example.grandtask.domain.repository.AlbumRepository

class GetAlbumUseCase(private val albumRepository: AlbumRepository) {
    suspend fun execute(userId:Int):Resource<List<Album>>{
        return albumRepository.getUserAlbum(userId)
    }
}