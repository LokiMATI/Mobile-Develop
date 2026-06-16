package com.example.labapplication.screens

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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.labapplication.data.UserViewModel

@Composable
fun RegistrationScreen(
    vm: UserViewModel = viewModel(),
    registrationButton: () -> Unit,
    authButton: () -> Unit){
    var login by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var errorData by remember { mutableStateOf(false) }
    var errorUserUnique by remember { mutableStateOf(false) }

    Box(Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){
        Column(Modifier.padding(5.dp), horizontalAlignment = Alignment.CenterHorizontally){
            Text("Регистрация")

            OutlinedTextField(
                login,
                {
                    login = it
                    errorUserUnique = false
                },
                leadingIcon = {Icon(Icons.Default.Person, "")},
                label = { Text("Логин") },
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth(),
                singleLine = true
            )

            OutlinedTextField(
                password,
                {password = it},
                label = {Text("Пароль")},
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth(),
                singleLine = true)

            if (errorData){
                Text("Неверные данные",
                    color = Color.Red,
                    modifier = Modifier.padding(5.dp))
            }

            if (errorUserUnique){
                Text("Пользователь с таким логином существует",
                    color = Color.Red,
                    modifier = Modifier.padding(5.dp))
            }

            Button({
                if (login.isNotBlank() && password.isNotBlank()){
                    if (vm.addUser(login, password)){
                        registrationButton()
                    }
                    else{
                        errorUserUnique = true
                    }
                }
                else{
                    errorData = true
                }
                   },
                Modifier.padding(5.dp).fillMaxWidth()) {
                Text("Зарегистрироваться")
            }

            Column(Modifier.padding(20.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                Text("У вас есть аккаунт?")
                TextButton(authButton) {
                    Text("Авторизация")
                }
            }
        }
    }
}