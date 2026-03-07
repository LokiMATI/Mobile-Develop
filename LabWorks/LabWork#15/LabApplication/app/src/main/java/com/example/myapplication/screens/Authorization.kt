package com.example.myapplication.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Authorization(
    inputPage : () -> Unit,
    regPage : () -> Unit){
    Icon(Icons.Filled.AccountCircle, contentDescription = "Авторизация")

    Column(
        Modifier
            .padding(8.dp)
            .fillMaxSize(1f),
        Arrangement.Center,
        Alignment.CenterHorizontally
    )
    {
        OutlinedTextField(
            "",
            {},
            label = {Text("Логин")}
        )

        OutlinedTextField(
            "",
            {},
            label = {Text("Пароль")}
        )

        Button({inputPage()})
        {
            Text("Войти")
        }

        Button({regPage()})
        {
            Text("Зарегистрироваться")
        }
    }
}