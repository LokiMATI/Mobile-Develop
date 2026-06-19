package com.example.application.ui.posts.add

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.application.NetworkClient

@Composable
fun AddPostScreen(modifier: Modifier, client: NetworkClient, onCreate: () -> Unit, onBack: () -> Unit)
{
    val vm: AddPostViewModel = viewModel()
    vm.client = client

    Column(modifier){
        OutlinedTextField(vm.title, {vm.updateTitle(it)}, Modifier.fillMaxWidth(), label = {Text("Название")})
        OutlinedTextField(vm.username, {vm.updateUsername(it)}, Modifier.fillMaxWidth(), label = {Text("Имя пользователя")})
        OutlinedTextField(vm.body, {vm.updateBody(it)}, Modifier.fillMaxWidth(), label = {Text("Комментарий")})

        Button({
            vm.addComment()
            onCreate()
        },
            Modifier.fillMaxWidth()) {
            Text("Создать")
        }

        Button(onBack, Modifier.fillMaxWidth()){
            Text("Назад")
        }
    }

}