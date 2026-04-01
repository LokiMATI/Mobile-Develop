package com.example.labapplication.screens

import android.content.Context
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun LicenseAgreementScreen(context : Context = LocalContext.current){
    var isAgreed by remember { mutableStateOf(false) }
    val text = context.assets
        .open("eula.txt")
        .bufferedReader().use {it.readText()}

    Column(Modifier.fillMaxSize()){
        Box(Modifier.height(400.dp).verticalScroll(rememberScrollState())){
            Text(text, Modifier.fillMaxSize())
        }

        Row(Modifier.fillMaxWidth()){
            Checkbox(isAgreed, {isAgreed = !isAgreed})
            Text("Я прочитал условия лицензионного соглашения")
        }

        Button({}, Modifier.fillMaxWidth(), enabled = isAgreed) {
            Text("Принять")
        }
    }
}