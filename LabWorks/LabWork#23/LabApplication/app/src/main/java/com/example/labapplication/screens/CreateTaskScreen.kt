package com.example.labapplication.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CreateTaskScreen(createTaskButton: () -> Unit, modifier: Modifier = Modifier){
    Column(modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly) {
        OutlinedTextField(
            "", {}, Modifier.fillMaxWidth(),
            label = { Text("Заголовок") },
            singleLine = true
        )

        OutlinedTextField(
            "", {}, Modifier.fillMaxWidth(),
            label = { Text("Описание") },
            minLines = 5,
            maxLines = 5
        )

        OutlinedTextField(
            "", {}, Modifier.fillMaxWidth(),
            label = { Text("Автор") },
            singleLine = true
        )

        OutlinedTextField(
            "", {}, Modifier.fillMaxWidth(),
            label = { Text("Статус") },
            singleLine = true
        )

        Button(createTaskButton) {
            Text("Создать")
        }
    }
}