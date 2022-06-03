package com.example.grandtask.data.api

import com.example.grandtask.data.model.album.Album
import com.example.grandtask.data.model.images.Image
import com.example.grandtask.data.model.user.Users
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface APIsService {

    @GET("users")
    suspend fun getAllUsers(): Response<List<Users>>

    @GET("albums")
    suspend fun getAllAlbums(@Query("userId") userId: Int ): Response<List<Album>>

    @GET("photos")
    suspend fun getAllPhotos(@Query("albumId") albumId: Int): Response<List<Image>>


}