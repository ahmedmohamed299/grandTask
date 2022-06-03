package com.example.grandtask.data.repository.user

import com.example.grandtask.data.model.user.Users
import com.example.grandtask.data.repository.user.dataSource.UserRemoteDataSource
import com.example.grandtask.data.util.Resource
import com.example.grandtask.domain.repository.UseRepository
import kotlin.random.Random

class UserRepositoryImpl(private val userRemoteDataSource: UserRemoteDataSource) :
    UseRepository {


    override suspend fun getAllUsersRemote(): Resource<Users> {
        val response =userRemoteDataSource.getAllUser()
        return if (response.isSuccessful&& response.body()!!.isNotEmpty()) {
            val users = response.body()
            val randomUser =Random.nextInt(0, users!!.size)

            Resource.Success(users[randomUser])

        } else {
            Resource.Error(userRemoteDataSource.getAllUser().message())
        }
    }


}