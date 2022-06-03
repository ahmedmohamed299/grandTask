package com.example.grandtask.domain.repository

import com.example.grandtask.data.model.user.Users
import com.example.grandtask.data.util.Resource
import kotlinx.coroutines.flow.Flow

interface UseRepository {
    suspend fun getAllUsersRemote():Resource<Users>
//    suspend fun getAllUsersFromDb(): Flow<List<Users>>
}