package com.example.labapplication.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlin.random.Random

@Composable
fun LinearDownload() {
    var progress by remember { mutableFloatStateOf(0f) }
    var isDownloading by remember { mutableStateOf(false) }

    if (isDownloading) {
        LaunchedEffect(Unit) {
            while (progress < 1.0f) {
                delay(100)
                val randomStep = Random.nextInt(1, 6) / 100f

                progress = (progress + randomStep).coerceAtMost(1.0f)
            }
            isDownloading = false
        }
    }

    Column(
        Modifier.fillMaxSize().padding(24.dp),
        Arrangement.Center,
        Alignment.CenterHorizontally
    ) {
        val percentText = (progress * 100).toInt()

        Text("Загружено: $percentText%",)

        LinearProgressIndicator(
            { progress }, Modifier.fillMaxWidth().padding(vertical = 8.dp)
        )
        LinearProgressIndicator(
            { progress }, Modifier.fillMaxWidth().padding(vertical = 8.dp),
            Color.Green, Color.LightGray
        )

        LinearProgressIndicator(
            { progress },
            Modifier.fillMaxWidth().padding(vertical = 8.dp),
            Color.Red,
            Color.LightGray
        )

        Button(
            {
                if (progress >= 1.0f) {
                    progress = 0f
                }
                isDownloading = true
            }, enabled = !isDownloading
        ) { Text("Скачать") }
    }
}