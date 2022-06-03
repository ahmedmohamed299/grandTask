package com.example.grandtask.data.repository.album.dataSource

import com.example.grandtask.data.model.album.Album
import retrofit2.Response

interface AlbumDataSource {
    suspend fun getUserAlbums(userId:Int):Response<List<Album>>
}