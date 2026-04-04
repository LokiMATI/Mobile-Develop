package com.example.databaseapp.data

import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PlayerRepository(private val playerDao: PlayerDao) {
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    val playerList: LiveData<List<Player>> = playerDao.getPlayers()

    fun addPlayer(player: Player){
        coroutineScope.launch(Dispatchers.IO) {
            playerDao.addPlayer(player)
        }
    }

    fun deletePlayer(player: Player){
        coroutineScope.launch(Dispatchers.IO) {
            playerDao.deletePlayer(player)
        }
    }
}