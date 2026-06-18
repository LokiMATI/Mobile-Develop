package com.example.lw28.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.example.lw28.data.Exercise

@Composable
fun EditFilmScreen(
    exercise: Exercise,
    onSave: (title: String, category: String, duration: Int, calories: Float) -> Unit,
    onCancel: () -> Unit
) {
    var title by remember { mutableStateOf(exercise.title) }
    var category by remember { mutableStateOf(exercise.category) }
    var duration by remember { mutableStateOf(exercise.duration.toString()) }
    var calories by remember { mutableStateOf(exercise.calories.toString()) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Редактирование упражнения", style = MaterialTheme.typography.headlineMedium)

        Spacer(Modifier.height(24.dp))

        Text(
            title,
            Modifier.fillMaxWidth(),
            fontSize = 10.em
        )

        Spacer(Modifier.height(8.dp))

        OutlinedTextField(
            category,
            { category = it },
            Modifier.fillMaxWidth(),
            label = { Text("Категория") },
        )

        Spacer(Modifier.height(8.dp))

        OutlinedTextField(
            duration,
            { duration = it },
            Modifier.fillMaxWidth(),
            label = { Text("Длительность (в минутах)") },
        )

        Spacer(Modifier.height(8.dp))

        OutlinedTextField(
            calories,
            { calories = it },
            Modifier.fillMaxWidth(),
            label = { Text("Рейтинг (1-10)") },
        )

        if (errorMessage != null)
            Text(errorMessage!!, color = MaterialTheme.colorScheme.error)

        Spacer(Modifier.height(16.dp))

        Row(
            Modifier.fillMaxWidth(),
            Arrangement.SpaceEvenly
        ) {
            Button({
                when {
                    title.isBlank() -> errorMessage = "Введите название"
                    category.isBlank() -> errorMessage = "Введите категорию"
                    duration.isBlank() -> errorMessage = "Введите продолжительность в минутах"
                    calories.isBlank() -> errorMessage = "Введите количество сжигаемых калорий"
                    else -> {
                        val durationInt = duration.toIntOrNull()
                        val caloriesFloat = calories.toFloatOrNull()
                        if (durationInt == null || durationInt <= 0)
                            errorMessage = "Продолжительность упражнения должна быть выше 0"
                        else if (caloriesFloat == null || caloriesFloat <= 0f)
                            errorMessage = "Количество сожённых калорий должно быть выще 0.0"
                        else
                            onSave(
                                title,
                                category,
                                durationInt,
                                caloriesFloat)
                    }
                }
            }) {
                Text("Сохранить")
            }

            Button(onCancel) {
                Text("Отмена")
            }
        }
    }
}