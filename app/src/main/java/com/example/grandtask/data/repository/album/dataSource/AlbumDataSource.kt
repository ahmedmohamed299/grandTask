package com.example.grandtask.data.repository.album.dataSource

import com.example.grandtask.data.model.album.Album
import com.example.grandtask.data.model.user.Users
import retrofit2.Response

interface AlbumDataSource {
    suspend fun getUserAlbums(userId: Users):Response<List<Album>>
}