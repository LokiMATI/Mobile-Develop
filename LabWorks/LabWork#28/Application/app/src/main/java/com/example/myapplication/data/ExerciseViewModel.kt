package com.example.myapplication.data

import android.app.Application
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

class ExerciseViewModel(app: Application) : AndroidViewModel(app) {
    private val repository: ExerciseRepository

    init {
        val exerciseDb = ExerciseRoomDatabase.getInstance(app)
        val exerciseDao = exerciseDb.ExerciseDao()
        repository = ExerciseRepository(exerciseDao)
    }

    var exercise: Exercise? = null
    var exercisesList = repository.exercisesList

    suspend fun getExercises(id: Int) : LiveData<Exercise>? {
        return repository.getExercise(id)
    }

    fun addExercise(title: String, category: String, duration: Int, burnCalories: Int){
        repository.addExercise(Exercise(title, category, duration, burnCalories))
    }

    fun updateExercise(id: Int, title: String, category: String, duration: Int, burnCalories: Int) {
        repository.updateExercise(Exercise(id, title, category, duration, burnCalories))
    }
}