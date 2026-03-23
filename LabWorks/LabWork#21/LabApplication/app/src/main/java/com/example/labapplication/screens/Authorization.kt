package com.example.labapplication.screens

import android.app.AlertDialog
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp

@Composable
fun Authorization(){
    var login by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var openDialog by remember { mutableStateOf(false) }

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

        Button({ openDialog = true}, Modifier
            .padding(5.dp)
            .width(200.dp)){
            Text("Авторизоваться")
        }

        if (openDialog){
            AlertDialog(
                onDismissRequest = { openDialog = false},
                title = {
                    when {
                        login.isNotBlank() && password.isNotBlank() ->
                            Text(text = "Добро пожаловать, $login")
                        else -> Text(text = "Ошибка")
                    }
                        },
                text = {
                    val stringBuilder = StringBuilder()

                    if (login.isBlank())
                        stringBuilder.appendLine("Поле login пустое")

                    if(password.isBlank())
                        stringBuilder.appendLine("Поле password пустое")

                    if (stringBuilder.toString().isNotBlank())
                        Text(stringBuilder.toString())
                },
                confirmButton = {
                    Button({ openDialog = false },
                        colors = ButtonColors(
                            containerColor = Color.Green,
                            contentColor = Color.Yellow,
                            disabledContainerColor = Color.Yellow,
                            disabledContentColor = Color.Yellow
                        )) {
                        Row(verticalAlignment = Alignment.CenterVertically){
                            Icon(Icons.Default.Check, "ОК")
                            Text("OK", fontSize = 22.sp)
                        }

                    }
                },
                dismissButton = {
                    if (login.isBlank() || password.isBlank())
                    Button({ openDialog = false },
                        colors = ButtonColors(
                            containerColor = Color.Red,
                            contentColor = Color.Yellow,
                            disabledContainerColor = Color.Yellow,
                            disabledContentColor = Color.Yellow
                        )
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically){
                            Icon(Icons.Default.Clear, "Отмена")
                            Text("Отмена", fontSize = 22.sp)
                        }
                    }
                },
                containerColor = Color.Cyan,
                textContentColor = Color.Magenta
            )
        }
    }
}