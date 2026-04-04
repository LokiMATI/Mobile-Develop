package com.example.labpplication.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.labpplication.viewmodel.UserViewModel

@Composable
fun UserInfo(login: String, backUpButton: () -> Unit, vm: UserViewModel = viewModel()){
    val user = vm.getUserByLogin(login)
    var password by remember { mutableStateOf(user!!.password) }
    var email by remember { mutableStateOf(user!!.email) }
    Column(Modifier.fillMaxSize()) { Text(user!!.login)

        OutlinedTextField(password, {password = it},
            label = {Text("Password")})

        OutlinedTextField(email,
            {email = it},
            label = {Text("Email")})

        Button({vm.updateUserByLogin(login, password, email)}) { Text("Сохранить") }

        IconButton(backUpButton) {
            Icon(Icons.AutoMirrored.Filled.ArrowBack, "Назад")
        }
    }
}
