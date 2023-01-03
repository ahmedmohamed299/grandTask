package com.example.grandtask.data.repository.user.dataSourceImpl

import com.example.grandtask.data.db.UserDao
import com.example.grandtask.data.model.user.Users
import com.example.grandtask.data.repository.user.dataSource.UserLocalDataSource
import kotlinx.coroutines.flow.Flow

class UserLocalDataSourceImpl(private val userDao: UserDao) : UserLocalDataSource {

    override suspend fun getAllUser(): Flow<List<Users>> = userDao.getAllCustomers()

    override suspend fun getUser(id: Int): Users = userDao.getCustomerById(id)

    override suspend fun insertUser(users: Users) = userDao.insertUser(users)

}