package com.example.myapplication.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myapplication.data.ExerciseViewModel

@Composable
fun CreateExerciseScreen(vm: ExerciseViewModel, saveButton: () -> Unit) {
    var title by remember { mutableStateOf("") }
    var category by remember { mutableStateOf("") }
    var duration by remember { mutableIntStateOf(0) }
    var burnCalories by remember { mutableIntStateOf(0) }

    Box(Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center)
    {
        Column(Modifier.padding(5.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            OutlinedTextField(title,
                {title = it},
                Modifier.fillMaxWidth(),
                label = {Text("Название")})

            OutlinedTextField(category,
                {category = it},
                Modifier.fillMaxWidth(),
                label = {Text("Категория")})

            OutlinedTextField(duration.toString(),
                {duration = it.toIntOrNull() ?: 0},
                Modifier.fillMaxWidth(),
                label = {Text("Продолжительность")})

            OutlinedTextField(burnCalories.toString(),
                {burnCalories = it.toIntOrNull() ?: 0},
                Modifier.fillMaxWidth(),
                label = {Text("Сожённые калории")})

            Button({
                if (title.isNotBlank() && category.isNotBlank()
                    && duration != 0 && burnCalories != 0){
                    vm.addExercise(title, category, duration, burnCalories)
                    saveButton()
                }
            }) { Text("Сохранить")}
        }
    }
}