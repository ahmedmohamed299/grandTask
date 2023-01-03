package com.example.grandtask.data.model.album

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "album")
data class Album(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val title: String,
    val userId: Int
)
