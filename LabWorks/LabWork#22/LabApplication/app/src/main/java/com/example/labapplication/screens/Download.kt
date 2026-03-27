package com.example.labapplication.screens

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun Download(){
    var isDownloading by remember { mutableStateOf(false) }



    if (isDownloading)
        CircularProgressIndicator()
}