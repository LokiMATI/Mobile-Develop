package com.example.labpplication.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
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
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.labpplication.Routes
import com.example.labpplication.viewmodel.UserViewModel

@Composable
fun UsersList(navController: NavController, vm: UserViewModel = viewModel()){
    val users = vm.userList
    var deleteResult by remember { mutableStateOf(false) }

    Column(Modifier.fillMaxSize()){
        OutlinedTextField(vm.userLogin,
            {vm.changeName(it)}, label = {Text("Name")})

        OutlinedTextField(vm.userPassword,
            {vm.changePassword(it)}, label = {Text("Password")})

        OutlinedTextField(vm.userEmail,
            {vm.changeEmail(it)}, label = {Text("Email")})

        Button({vm.addUser()}){ Text("Добавить") }

        Button({ deleteResult = !vm.deleteUserByLogin(vm.userLogin) }){
            Text("Удалить") }

        if (deleteResult)
            AlertDialog(
                onDismissRequest = {deleteResult = false}, title = {Text("Ошибка удаления")},
                text = {Text("Пользователь не был найден")}, confirmButton = {
                    Button({deleteResult = false}) { Text("Ок", fontSize = 22.sp) }
                })

        LazyColumn(Modifier.fillMaxWidth()) {
            items(items = users){ u ->
                Row(Modifier.fillMaxWidth().padding(8.dp).clickable{
                    navController.navigate(Routes.UserInfo.route + "/${u.login}") },
                    verticalAlignment = Alignment.CenterVertically) { Text(u.login) }
            }
        }
    }
}
