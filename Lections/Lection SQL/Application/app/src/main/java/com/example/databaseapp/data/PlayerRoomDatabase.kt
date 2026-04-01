package com.example.databaseapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database([(Player::class)], version = 1)
abstract class PlayerRoomDatabase: RoomDatabase() {
    abstract fun getPlayerDao(): PlayerDao

    companion object{
        private var INSTANCE: PlayerRoomDatabase? = null

        fun getInstance(context: Context): PlayerRoomDatabase {
            synchronized(this){
                var instance = INSTANCE
                if (instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        PlayerRoomDatabase::class.java,
                        "player_database"
                    ).fallbackToDestructiveMigration().build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}