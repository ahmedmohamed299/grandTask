package com.example.grandtask.data.repository.user.dataSource

import com.example.grandtask.data.model.user.Users
import retrofit2.Response

interface UserRemoteDataSource {

    suspend fun getAllUser():Response<List<Users>>
}