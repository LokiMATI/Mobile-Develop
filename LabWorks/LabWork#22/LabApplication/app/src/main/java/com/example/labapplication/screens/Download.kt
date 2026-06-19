package com.example.labapplication.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun Download(){
    var isDownloading by remember { mutableStateOf(false) }

    if (isDownloading) {
        LaunchedEffect(Unit) {
            delay(10000)
            isDownloading = false
        }
    }

    Column(
        Modifier.fillMaxSize().padding(16.dp),
        Arrangement.Center,
        Alignment.CenterHorizontally
    ) {
        if (isDownloading) {
            CircularProgressIndicator()
        }

        Button({ isDownloading = true },
            enabled = !isDownloading
        ) {
            Text("Скачать")
        }
    }
}