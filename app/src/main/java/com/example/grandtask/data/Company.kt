package com.example.grandtask.data

import com.google.gson.annotations.SerializedName

data class Company(
    @SerializedName("bs")
    val bs: String,
    val catchPhrase: String,
    val name: String
)