package com.example.labapplication.screens

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext


@Composable
fun RegistrationScreen(context : Context = LocalContext.current){
    var login by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val weakPasswords = context.assets
        .open("weak_passwords.txt")
        .bufferedReader().use {it.readLines()}

    Column(Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally){
        OutlinedTextField(login, {login = it}, Modifier.fillMaxWidth(),
            label = {Text("Логин")})

        OutlinedTextField(password, {password = it}, Modifier.fillMaxWidth(),
            label = {Text("Пароль")})

        if (weakPasswords.contains(password)){
            Text("Пароль фигня.")
        }
    }
}