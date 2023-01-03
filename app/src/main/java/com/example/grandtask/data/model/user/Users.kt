package com.example.grandtask.data.model.user

import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.grandtask.data.model.album.Album
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
@Entity(tableName = "user")
data class Users(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val email: String,
    @Embedded
    val address: @RawValue Address,
    val name: String,
    val phone: String,
    val username: String,
    val website: String,
    var album: @RawValue List<Album>
): Parcelable