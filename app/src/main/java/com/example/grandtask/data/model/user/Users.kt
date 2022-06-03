package com.example.grandtask.data.model.user

import com.example.grandtask.data.model.user.Address
import com.example.grandtask.data.model.user.Company


data class Users(
    val address: Address,
    val company: Company,
    val email: String,
    val id: Int,
    val name: String,
    val phone: String,
    val username: String,
    val website: String
)