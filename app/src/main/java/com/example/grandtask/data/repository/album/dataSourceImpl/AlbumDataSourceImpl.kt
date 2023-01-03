package com.example.grandtask.data.repository.album.dataSourceImpl

import com.example.grandtask.data.api.APIsService
import com.example.grandtask.data.model.album.Album
import com.example.grandtask.data.model.user.Users
import com.example.grandtask.data.repository.album.dataSource.AlbumDataSource
import retrofit2.Response

class AlbumDataSourceImpl(private val apIsService: APIsService) : AlbumDataSource {
    override suspend fun getUserAlbums(user: Users): Response<List<Album>> {
        return apIsService.getAllAlbums(user.id)

    }


}