package com.example.myapplication.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Registration(
    okPage : () -> Unit){
    Icon(Icons.Filled.Create, contentDescription = "Регистрация")

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
        OutlinedTextField(
            "",
            {},
            label = {
                Text(
                    "Подтверждение пароля",
                )
            }
        )

        OutlinedTextField(
            "",
            {},
            label = {
                Text(
                    "Номер телефона",
                )
            }
        )

        OutlinedTextField(
            "",
            {},
            label = {
                Text(
                    "Email",
                )
            }
        )

        OutlinedTextField(
            "",
            {},
            label = {
                Text(
                    "Возраст",
                )
            }
        )

        Button({okPage()})
        {
            Text("ОК")
        }
    }
}