package com.example.lw28

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.lw28.data.Exercise
import com.example.lw28.database.ExerciseDatabaseHelper
import com.example.lw28.ui.AddExerciseScreen
import com.example.lw28.ui.EditFilmScreen
import com.example.lw28.ui.ExercisesListScreen

class MainActivity : ComponentActivity() {
    private lateinit var databaseHelper: ExerciseDatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        databaseHelper = ExerciseDatabaseHelper(this)
        setContent {
            Scaffold { innerPadding ->
                Box(Modifier.padding(innerPadding)){
                    App(databaseHelper)
                }
            }
        }
    }
}

@Composable
fun App(databaseHelper: ExerciseDatabaseHelper) {
    var showAddScreen by remember { mutableStateOf(false) }
    var exerciseToEdit by remember { mutableStateOf<Exercise?>(null) }
    var refreshTrigger by remember { mutableIntStateOf(0) }

    fun refreshList() {
        refreshTrigger++
    }

    if (showAddScreen) {
        AddExerciseScreen(
            { title, genre, year, rating ->
                databaseHelper.insertExercise(title, genre, year, rating)
                refreshList()
                showAddScreen = false
            },
            { showAddScreen = false }
        )
    } else if (exerciseToEdit != null) {
        EditFilmScreen(
            exerciseToEdit!!,
            { title, category, duration, calories ->
                databaseHelper.updateExercise(title, category, duration, calories)
                refreshList()
                exerciseToEdit = null
            },
            { exerciseToEdit = null }
        )
    } else {
        ExercisesListScreen(
            databaseHelper,
            refreshTrigger,
            { showAddScreen = true },
            { film -> exerciseToEdit = film }
        )
    }
}