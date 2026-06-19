package com.example.labapplication.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import kotlinx.coroutines.delay

@SuppressLint("DefaultLocale")
@Composable
fun Timer() {
    val totalSeconds = 60

    var secondsLeft by remember { mutableIntStateOf(totalSeconds) }
    var isRunning by remember { mutableStateOf(false) }

    val progressFraction = secondsLeft.toFloat() / totalSeconds

    val indicatorColor = when {
        secondsLeft >= 30 -> Color.Green
        secondsLeft in 10..29 -> Color.Yellow
        else -> Color.Red
    }

    if (isRunning) {
        LaunchedEffect(Unit) {
            while (secondsLeft > 0) {
                delay(1000) // Ждем 1 секунду
                secondsLeft--
            }
            isRunning = false
        }
    }

    Column(Modifier.fillMaxSize().padding(24.dp),
        Arrangement.Center,
        Alignment.CenterHorizontally
    ) {
        Box(
            Modifier.size(200.dp), Alignment.Center
        ) {
            CircularProgressIndicator(
                { progressFraction },
                Modifier.fillMaxSize(),
                indicatorColor,
                12.dp,
                Color.LightGray.copy(alpha = 0.3f)
            )

            Text(secondsLeft.toString(), fontSize = 10.em)
        }

        Button(
            {
                if (secondsLeft == 0) {
                    secondsLeft = totalSeconds
                }
                isRunning = true
            }, enabled = !isRunning
        ) {
            Text("Старт")
        }
    }
}