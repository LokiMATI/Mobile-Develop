package com.example.myapplication.data

import android.content.Context
import androidx.room.Room
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase

abstract class ExerciseRoomDatabase: RoomDatabase() {
    abstract fun ExerciseDao(): ExerciseDao

    companion object {
        private var INSTANCE: ExerciseRoomDatabase? = null
        fun getInstance(context: Context): ExerciseRoomDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = databaseBuilder(
                        context.applicationContext,
                        ExerciseRoomDatabase::class.java,
                        "User_database"
                    ).fallbackToDestructiveMigration().build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}