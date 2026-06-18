package com.example.lw28.database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.lw28.data.Exercise

class ExerciseDatabaseHelper(context: Context) : SQLiteOpenHelper(
    context,
    DATABASE_NAME,
    null,
    1) {

    companion object {
        private const val DATABASE_NAME = "exercises.db"
        private const val TABLE_NAME = "exercises"
        private const val COL_TITLE = "title"
        private const val COL_CATEGORY = "category"
        private const val COL_DURATION = "duration"
        private const val COL_CALORIES = "calories"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTable = """
            CREATE TABLE $TABLE_NAME (
                $COL_TITLE TEXT PRIMARY KEY,
                $COL_CATEGORY TEXT NOT NULL,
                $COL_DURATION INTEGER NOT NULL,
                $COL_CALORIES REAL NOT NULL
            )
        """.trimIndent()
        db.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun getAllExercises(): List<Exercise> {
        val films = mutableListOf<Exercise>()
        val db = readableDatabase
        val cursor = db.query(
            TABLE_NAME,
            null,
            null,
            null,
            null,
            null,
            null)

        with(cursor) {
            while (moveToNext()) {
                val title = getString(getColumnIndexOrThrow(COL_TITLE))
                val category = getString(getColumnIndexOrThrow(COL_CATEGORY))
                val duration = getInt(getColumnIndexOrThrow(COL_DURATION))
                val calories = getFloat(getColumnIndexOrThrow(COL_CALORIES))
                films.add(Exercise(title, category, duration, calories))
            }
        }
        cursor.close()
        return films
    }

    fun insertExercise(title: String, category: String, duration: Int, calories: Float): Long {
            val db = writableDatabase
        val values = ContentValues().apply {
            put(COL_TITLE, title)
            put(COL_CATEGORY, category)
            put(COL_DURATION, duration)
            put(COL_CALORIES, calories)
        }
        return db.insert(TABLE_NAME, null, values)
    }

    fun updateExercise(title: String, genre: String, year: Int, rating: Float): Int {
        val db = writableDatabase
        val values = ContentValues().apply {
            put(COL_CATEGORY, genre)
            put(COL_DURATION, year)
            put(COL_CALORIES, rating)
        }
        return db.update(
            TABLE_NAME,
            values,
            "$COL_TITLE = ?",
            arrayOf(title))
    }

    fun deleteExercise(title: String): Int {
        val db = writableDatabase
        return db.delete(TABLE_NAME,
            "$COL_TITLE = ?",
            arrayOf(title))
    }
}
