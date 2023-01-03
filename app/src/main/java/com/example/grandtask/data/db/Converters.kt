package com.example.grandtask.data.db

import androidx.room.TypeConverter
import com.example.grandtask.data.model.album.Album
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.util.*

class Converters {

    @TypeConverter
    fun stringToListWeather(data: String?): List<Album>? {
        if (data == null) {
            return Collections.emptyList()
        }
        val listType: Type = object :
            TypeToken<List<Album>?>() {}.type
        return Gson().fromJson<List<Album>>(data, listType)
    }

    @TypeConverter
    fun listWeatherToString(someObjects: List<Album>?): String? {
        return Gson().toJson(someObjects)
    }

}