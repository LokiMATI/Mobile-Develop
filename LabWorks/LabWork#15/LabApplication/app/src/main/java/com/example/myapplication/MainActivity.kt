package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.screens.Authorization
import com.example.myapplication.screens.Profile
import com.example.myapplication.screens.Registration
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    var current by remember { mutableStateOf( Pages.AUTHORIZATION) }

                    Column(
                        Modifier.padding(innerPadding),
                        Arrangement.Center,
                        Alignment.CenterHorizontally
                    ) {
                        NavBar(
                            {current = Pages.AUTHORIZATION},
                            {current = Pages.REGISTRATION},
                            {current = Pages.PROFILE},
                        )

                        when (current){
                            Pages.AUTHORIZATION -> Authorization(
                                {current = Pages.PROFILE},
                                {current = Pages.REGISTRATION})
                            Pages.REGISTRATION -> Registration({current = Pages.AUTHORIZATION})
                            Pages.PROFILE -> Profile({current = Pages.AUTHORIZATION})
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun NavBar(
    authPage : () -> Unit,
    regPage : () -> Unit,
    profilePage : () -> Unit) {
    Row(
        Modifier
            .padding(8.dp)
            .fillMaxWidth(1f),
        Arrangement.SpaceEvenly,
        Alignment.CenterVertically){
        Button({authPage()}) { Text("Авторизация") }
        Button({regPage()}) { Text("Регистрация") }
        Button({profilePage()}) { Text("Профиль") }
    }
}

enum class Pages{
    AUTHORIZATION,
    REGISTRATION,
    PROFILE
}