package com.example.labapplication.screens

import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.labapplication.data.UserViewModel

@Composable
fun AuthorizationScreen(
    vm: UserViewModel = viewModel(),
    authButton: () -> Unit,
    registrationButton: () -> Unit){
    var login by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var error by remember { mutableStateOf(false) }

    Box(Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){
        Column(Modifier.padding(5.dp), horizontalAlignment = Alignment.CenterHorizontally){
            Text("Авторизация")

            OutlinedTextField(
                login,
                {login = it},
                leadingIcon = {Icon(Icons.Default.Person, "")},
                label = {Text("Логин")},
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth(),
                singleLine = true)

            OutlinedTextField(
                password,
                {password = it},
                label = {Text("Пароль")},
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth(),
                singleLine = true)

            if (error){
                Text("Неверный логин или пароль",
                    color = Color.Red,
                    modifier = Modifier.padding(5.dp))
            }

            Button({
                if (vm.authorization(login, password)) {
                    authButton()
                }
                else {
                    error = true
                }
                   },
                Modifier.padding(5.dp).fillMaxWidth()) {
                Text("Войти")
            }

            Column(Modifier.padding(20.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Нет аккаунта?")
                TextButton(registrationButton) {
                    Text("Регистрация")
                }
            }
        }
    }
}