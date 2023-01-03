package com.example.grandtask.data.repository.user.dataSource

import com.example.grandtask.data.model.user.Users
import kotlinx.coroutines.flow.Flow

interface UserLocalDataSource {
    suspend fun getAllUser(): Flow<List<Users>>
    suspend fun getUser(id: Int): Users
    suspend fun insertUser(users: Users)

}