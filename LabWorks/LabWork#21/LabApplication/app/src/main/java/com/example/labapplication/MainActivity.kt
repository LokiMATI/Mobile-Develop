package com.example.labapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.labapplication.screens.Authorization
import com.example.labapplication.ui.theme.LabApplicationTheme
import kotlinx.coroutines.launch
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LabApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(Modifier.padding(innerPadding))

                    {
//                        Authorization()
//                        ClearCash()
                        Play()
                    }
                }
            }
        }
    }
}

@Composable
fun ClearCash() {
    val snackbarHostState  = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    var memCash by remember { mutableStateOf(Random.nextInt(1000)) }

    Scaffold(modifier = Modifier.fillMaxSize(),
        snackbarHost = { SnackbarHost(snackbarHostState)}){ innerPadding ->
        Column(Modifier.fillMaxSize()){
            Text("$memCash МБ")
            Button({
                scope.launch {
                    snackbarHostState.showSnackbar("Кэш очищен",
                        duration = SnackbarDuration.Short)
                }

                memCash = 0
            }){
                Text("Очистить кэш")
            }
        }
    }
}

@Composable
fun Play() {
    val snackbarHostState  = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    var isAddResources by remember { mutableStateOf(false) }
    var isStartGame by remember { mutableStateOf(false) }

    Scaffold(modifier = Modifier.fillMaxSize(),
        snackbarHost = { SnackbarHost(snackbarHostState)}){ innerPadding ->
        Column(Modifier.fillMaxSize()){
            Button({
                scope.launch {
                    val result = snackbarHostState.showSnackbar("Загрузить дополнительные ресурсы?",
                        actionLabel = "Ок",
                        withDismissAction = true,
                        duration = SnackbarDuration.Indefinite)

                    when (result){
                        SnackbarResult.ActionPerformed -> {
                            isStartGame = true
                            isAddResources = true
                        }
                        SnackbarResult.Dismissed -> isStartGame = true
                    }
                }
            }){
                Text("Играть")
            }
            if (isStartGame)
                Text("Вы вошли в игру")
            if (isAddResources)
                Image(painter = painterResource(R.drawable.cthulhu_star),
                    contentDescription = "Текст", Modifier.size(60.dp))
        }
    }
}