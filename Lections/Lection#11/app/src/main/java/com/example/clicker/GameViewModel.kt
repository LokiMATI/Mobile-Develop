package com.example.clicker

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel(){
    var score by mutableIntStateOf(0)

    fun onTap(){
        score++
    }
}