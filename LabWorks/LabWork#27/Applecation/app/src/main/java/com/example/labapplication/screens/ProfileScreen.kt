package com.example.labapplication.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
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
import androidx.compose.ui.unit.sp
import com.example.labapplication.data.UserViewModel

@Composable
fun ProfileScreen(vm: UserViewModel, exitButton: () -> Unit){
    var name by remember { mutableStateOf(vm.userName) }
    var surname by remember { mutableStateOf(vm.userSurname) }
    Box(Modifier.fillMaxSize()){
        Column(Modifier.padding(5.dp), horizontalAlignment = Alignment.CenterHorizontally){
            Text("Профиль")

            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.Person, "")
                Text(vm.userLogin.toString(), fontSize = 50.sp)
            }

            OutlinedTextField(
                name,
                {vm.changeName(it)
                name = it},
                label = {Text("Имя")},
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth(),
                singleLine = true)

            OutlinedTextField(
                surname,
                {vm.changeSurname(it)
                surname = it},
                label = {Text("Фамилия")},
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth(),
                singleLine = true)

            TextButton(exitButton,
                Modifier.padding(5.dp).fillMaxWidth()) {
                Text("Выйти")
            }
        }
    }
}