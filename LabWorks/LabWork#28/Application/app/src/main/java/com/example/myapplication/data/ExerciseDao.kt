package com.example.myapplication.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ExerciseDao {
    @Query("SELECT * FROM exercises")
    fun getExercises() : LiveData<List<Exercise>>

    @Query("SELECT * FROM exercises WHERE exerciseId = :exerciseId")
    fun getExercise(exerciseId: Int) : LiveData<Exercise>

    @Insert
    fun addExercise(exercise: Exercise)

    @Update
    fun updateExercise(exercise: Exercise)

    @Delete
    fun deleteExercise(exercise: Exercise)
}