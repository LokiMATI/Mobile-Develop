package com.example.labapplication.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em

@Composable
fun Authorization(okButton : () -> Unit,
                  registrationButton : () -> Unit){
    var login by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center){
        Text("Авторизация", Modifier.padding(10.dp),
            fontSize = 10.em)

        OutlinedTextField(login,
            {login = it},
            label = {Text("Логин")},
            modifier = Modifier.padding(10.dp))

        OutlinedTextField(password,
            {password = it},
            label = {Text("Пароль")},
            modifier = Modifier.padding(10.dp))

        Button(okButton, Modifier.padding(5.dp).width(200.dp)){
            Text("ОК")
        }

        Button(registrationButton, Modifier.width(200.dp)){
            Text("Регистрация")
        }
    }
}
