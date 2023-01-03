package com.example.grandtask.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.grandtask.data.model.user.Users
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Insert(onConflict = REPLACE)
    suspend fun insertUser(users: Users)

    @Query("SELECT * FROM user")
    fun getAllCustomers(): Flow<List<Users>>

    @Query("SELECT * FROM user WHERE id = :id")
    suspend fun getCustomerById(id: Int): Users


}