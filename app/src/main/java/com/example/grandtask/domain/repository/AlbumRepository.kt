package com.example.grandtask.domain.repository

import com.example.grandtask.data.model.album.Album
import com.example.grandtask.data.util.Resource

interface AlbumRepository {
    suspend fun getUserAlbum(userId:Int):Resource<List<Album>>
}