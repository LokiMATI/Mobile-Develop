package com.example.labapplication.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAbsoluteAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.intellij.lang.annotations.JdkConstants

@Preview(showBackground = true)
@Composable
fun Auth(){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    )
    {
        Text(
            "Авторизация",
            fontSize = 30.sp
        )

        TextField(
            label = {Text("Логин")},
            value = "",
            onValueChange = {},
            modifier = Modifier.padding(10.dp)
        )

        TextField(
            label = {Text("Пароль")},
            value = "",
            onValueChange = {},
            modifier = Modifier.padding(10.dp)
        )

        Button({})
        {
            Text(
                "Авторизоваться",
                fontSize = 30.sp
            )
        }
    }
}