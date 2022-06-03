package com.example.grandtask.data.repository.user.dataSourceImpl

import com.example.grandtask.data.api.APIsService
import com.example.grandtask.data.model.user.Users
import com.example.grandtask.data.repository.user.dataSource.UserRemoteDataSource
import retrofit2.Response

class UserRemoteDataSourceImpl(private val apIsService: APIsService) : UserRemoteDataSource {
    override suspend fun getAllUser(): Response<List<Users>> {
        return apIsService.getAllUsers()
    }
}