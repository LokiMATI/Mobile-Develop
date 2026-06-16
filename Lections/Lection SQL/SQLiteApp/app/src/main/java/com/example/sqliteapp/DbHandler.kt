package com.example.sqliteapp

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import kotlin.math.log

class DbHandler(context: Context)
    : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {
        val query = ("CREATE TABLE $USERS_TABLE(" +
                "$ID_COL INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$LOGIN_COL TEXT NOT NULL UNIQUE, " +
                "$PASSWORD_COL TEXT NOT NULL )")

        db.execSQL(query)
    }

    override fun onUpgrade(
        db: SQLiteDatabase,
        oldVersion: Int,
        newVersion: Int
    ) {
        db.execSQL("DROP TABLE IF EXISTS $USERS_TABLE")
        onCreate(db)
    }

    fun addUser(login: String, password: String){
        val db = writableDatabase

        val values = ContentValues()
        values.put(LOGIN_COL, login)
        values.put(PASSWORD_COL, password)

        db.insert(USERS_TABLE, null, values)
        db.close()
    }

    fun getUsers(): List<User> {
        val db = readableDatabase
        val cursor = db.rawQuery("SELECT * FROM $USERS_TABLE", null)

        val usersArrayList: ArrayList<User> = ArrayList()

        cursor.use {
            if (cursor.moveToFirst()){
                do {
                    usersArrayList.add(User(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2)
                    ))
                } while (cursor.moveToNext())
            }
        }

        return usersArrayList
    }

    companion object{
        private const val DB_NAME = "users_db"
        private const val DB_VERSION = 1
        private const val USERS_TABLE = "users"
        private const val ID_COL = "id"
        private const val LOGIN_COL = "login"
        private const val PASSWORD_COL = "password"
    }
}