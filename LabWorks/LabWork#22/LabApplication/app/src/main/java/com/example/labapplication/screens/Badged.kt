package com.example.labapplication.screens

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import kotlin.random.Random

@Composable
fun Badge() {
    val context = LocalContext.current

    var messageCount by remember { mutableIntStateOf(0) }

    Column(
        Modifier.fillMaxSize().padding(24.dp),
        Arrangement.Center,
        Alignment.CenterHorizontally
    ) {

        BadgedBox(
            badge = {
                if (messageCount > 0) {
                    Badge(
                        containerColor = Color.Red,
                        contentColor = Color.White
                    ) {
                        Text(messageCount.toString())
                    }
                }
            }
        ) {
            Icon(
                Icons.Filled.Email, "Письма",
                Modifier.size(48.dp)
                    .clickable {
                        Toast.makeText(context, "Все сообщения прочитаны", Toast.LENGTH_SHORT).show()
                        messageCount = 0
                    }
            )
        }

        Button({
            val randomMessages = Random.nextInt(1, 6)
            messageCount += randomMessages
        }
        ) {
            Text("Обновить")
        }
    }
}
