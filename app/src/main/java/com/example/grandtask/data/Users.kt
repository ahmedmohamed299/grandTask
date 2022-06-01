package com.example.grandtask.data


import com.google.gson.annotations.SerializedName

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