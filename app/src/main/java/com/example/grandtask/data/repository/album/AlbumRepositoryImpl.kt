package com.example.grandtask.data.repository.user

import com.example.grandtask.data.model.album.Album
import com.example.grandtask.data.model.user.Users
import com.example.grandtask.data.repository.album.dataSource.AlbumDataSource
import com.example.grandtask.data.repository.album.dataSourceImpl.AlbumDataSourceImpl
import com.example.grandtask.data.repository.user.dataSource.UserLocalDataSource
import com.example.grandtask.data.util.Resource
import com.example.grandtask.domain.repository.AlbumRepository

class AlbumRepositoryImpl(
    private val albumDataSource: AlbumDataSource,
    private val userDataSource: UserLocalDataSource
) : AlbumRepository {
    override suspend fun getUserAlbum(user: Users): Resource<List<Album>> {
        val response = albumDataSource.getUserAlbums(user)
        return if (response.isSuccessful) {
            user.apply {
                album = response.body()!!
            }
            userDataSource.insertUser(user)
            Resource.Success(response.body()!!)
        } else {
            Resource.Error(response.message())
        }
    }
}