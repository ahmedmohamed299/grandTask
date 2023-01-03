package com.example.grandtask.presentation.di

import android.app.Application
import androidx.room.Room
import com.example.grandtask.data.db.UserDao
import com.example.grandtask.data.db.UserDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideNewsDatabase(app: Application): UserDatabase {
        return Room.databaseBuilder(app, UserDatabase::class.java, "customer_db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideWeatherDao(database: UserDatabase): UserDao {
        return database.getUsers()
    }


}