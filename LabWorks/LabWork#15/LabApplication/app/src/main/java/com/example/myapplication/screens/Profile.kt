package com.example.myapplication.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Profile(backPage : () -> Unit){
    Icon(Icons.Filled.Info, contentDescription = "Профиль")

    Column(
        Modifier
            .padding(8.dp)
            .fillMaxSize(1f),
        Arrangement.Center,
        Alignment.CenterHorizontally
    )
    {
        Row(Modifier
            .padding(16.dp)) {
            Text("Логин: ")

            Text("Lucky")
        }

        Row(Modifier
            .padding(16.dp)) {
            Text("Имя: ")

            Text("Никита")
        }

        Row(Modifier
            .padding(16.dp)) {
            Text("Возраст: ")

            Text("19")
        }

        Row(Modifier
            .padding(16.dp)) {
            Text("Email: ")

            Text("r.matigorov@yandex.ru")
        }

        Column(Modifier
            .padding(16.dp)) {
            Text("О себе")

            Text("Тестовая информация")
        }

        Button({backPage()})
        {
            Text("Назад")
        }
    }
}