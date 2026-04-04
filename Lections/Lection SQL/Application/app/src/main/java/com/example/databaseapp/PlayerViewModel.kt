package com.example.databaseapp

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.databaseapp.data.Player
import com.example.databaseapp.data.PlayerRepository
import com.example.databaseapp.data.PlayerRoomDatabase

class PlayerViewModel(app: Application) : AndroidViewModel(app) {
    val playerList: LiveData<List<Player>>
    private val repository: PlayerRepository
    var playerName by mutableStateOf("")
    var playerLevel by mutableIntStateOf(0)

    init {
        val playerDb = PlayerRoomDatabase.getInstance(app)
        val playerDao = playerDb.getPlayerDao()
        repository = PlayerRepository(playerDao)
        playerList = repository.playerList
    }

    fun changeName(value: String){
        playerName = value
    }

    fun changeLevel(value: String){
        playerLevel = value.toIntOrNull() ?: playerLevel
    }

    fun addPlayer(){
        repository.addPlayer(Player(playerName, playerLevel))
    }

    fun deletePlayer(player: Player){
        repository.deletePlayer(player)
    }
}