package com.example.lw28.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.lw28.data.Exercise
import com.example.lw28.database.ExerciseDatabaseHelper

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExercisesListScreen(
    databaseHelper: ExerciseDatabaseHelper,
    refreshTrigger: Int,
    onAddClick: () -> Unit,
    onEditClick: (Exercise) -> Unit
) {
    var exercises by remember { mutableStateOf(listOf<Exercise>()) }

    LaunchedEffect(refreshTrigger) {
        exercises = databaseHelper.getAllExercises()
    }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onAddClick) {
                Text("+")
            }
        }
    ) { paddingValues ->
        Column(
            Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            if (exercises.isEmpty()) {
                Box(
                    Modifier.fillMaxSize(),
                    Alignment.Center
                ) {
                    Text("Нет упражнений. Нажмите + для добавления")
                }
            } else {
                LazyColumn(
                    Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(exercises) { exercise ->
                        ExerciseCard(
                            exercise,
                            { onEditClick(exercise) },
                            {
                                databaseHelper.deleteExercise(exercise.title)
                                exercises = databaseHelper.getAllExercises()
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ExerciseCard(exercise: Exercise, onEdit: () -> Unit, onDelete: () -> Unit) {
    Card(Modifier.fillMaxWidth()) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(exercise.title, style = MaterialTheme.typography.titleLarge)
            Text("Категория: ${exercise.category}")
            Text("Длительность (мин): ${exercise.duration}")
            Text("Сожённые калории: ${exercise.calories}")

            Row(
                Modifier.fillMaxWidth(),
                Arrangement.End
            ) {
                Button(onEdit) {
                    Text("Изменить")
                }

                Spacer(Modifier.width(8.dp))

                Button(
                    onDelete,
                    colors = ButtonDefaults.buttonColors(
                        MaterialTheme.colorScheme.error
                    )
                ) {
                    Text("Удалить")
                }
            }
        }
    }
}
