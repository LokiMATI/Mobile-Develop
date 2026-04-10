package com.example.myapplication.data

import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class ExerciseRepository(private val exerciseDao: ExerciseDao) {
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    val exercisesList: LiveData<List<Exercise>>? = exerciseDao.getExercises()

    suspend fun getExercise(id: Int) : LiveData<Exercise>? {
        return coroutineScope {
            exerciseDao.getExercise(id)
        }
    }

    fun addExercise(exercise: Exercise) {
        coroutineScope.launch(Dispatchers.IO) {
            exerciseDao.addExercise(exercise)
        }
    }

    fun updateExercise(exercise: Exercise) {
        coroutineScope.launch(Dispatchers.IO) {
            exerciseDao.updateExercise(exercise)
        }
    }

    fun deleteExercise(exercise: Exercise){
        coroutineScope.launch(Dispatchers.IO) {
            exerciseDao.deleteExercise(exercise)
        }
    }
}