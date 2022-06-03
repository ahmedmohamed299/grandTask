package com.example.grandtask.data.repository.user

import com.example.grandtask.data.model.album.Album
import com.example.grandtask.data.repository.album.dataSource.AlbumDataSource
import com.example.grandtask.data.repository.album.dataSourceImpl.AlbumDataSourceImpl
import com.example.grandtask.data.util.Resource
import com.example.grandtask.domain.repository.AlbumRepository

class AlbumRepositoryImpl(private val albumDataSource: AlbumDataSource) : AlbumRepository {
    override suspend fun getUserAlbum(userId: Int): Resource<List<Album>> {
        val response = albumDataSource.getUserAlbums(userId)
        return if (response.isSuccessful){
            Resource.Success(response.body()!!)
        }else{
            Resource.Error(response.message())
        }
    }
}