package com.example.grandtask.domain.repository

import com.example.grandtask.data.model.album.Album
import com.example.grandtask.data.model.user.Users
import com.example.grandtask.data.util.Resource

interface AlbumRepository {
    suspend fun getUserAlbum(user: Users):Resource<List<Album>>
}