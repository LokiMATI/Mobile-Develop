package com.example.application

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.example.application.ui.theme.ApplicationTheme

private const val TAG = "MathApp"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        var screenText: String
        try {
            val result1 = divideNumbers(10.0, 2.0)
            Log.i(TAG, "Успешное деление 10 на 2. Результат: $result1")

            val result2 = divideNumbers(5.0, 0.0)
            screenText = "Результат: $result2"
        } catch (e: IllegalArgumentException) {
            Log.e(TAG, "Произошла ошибка деления!", e)
            screenText = "Ошибка: ${e.message}"
        }

        setContent {
            ApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(Modifier.padding(innerPadding)) {
                        Text(screenText, Modifier.padding(innerPadding))
                        LoginScreen()
                    }
                }
            }
        }
    }
}

fun divideNumbers(dividend: Double, divisor: Double): Double {
    if (divisor == 0.0) {
        throw IllegalArgumentException("Деление на ноль ЗАПРЕЩЕНО!!!")
    }
    return dividend / divisor
}

@Composable
fun LoginScreen() {
    val allowedUsers = mapOf(
        "admin" to "admin",
        "user" to "qwerty",
        "lucky" to "Test"
    )

    var login by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var statusText by remember { mutableStateOf("") }

    Column(Modifier.fillMaxSize().padding(16.dp),
        Arrangement.Center,
        Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            login,
            { login = it },
            Modifier
                .fillMaxWidth()
                .testTag("login_input"),
            label = { Text("Логин") }
        )

        OutlinedTextField(
            password,
            { password = it },
            Modifier.fillMaxWidth().testTag("password_input"),
            label = { Text("Пароль") }
        )

        Button(
            {
                val correctPassword = allowedUsers[login]
                if (correctPassword != null && correctPassword == password) {
                    statusText = "Успешная авторизация"
                } else {
                    statusText = "Неуспешная авторизация"
                }
            },
            Modifier.fillMaxWidth().testTag("login_button")
        ) {
            Text("Войти")
        }

        if (statusText.isNotEmpty()) {
            Text(text = statusText)
        }
    }
}