package com.example.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

data class User(val name : String, val age : Int)

class UserListViewModel : ViewModel() {
    val users = mutableStateListOf<User>()

    var userName by mutableStateOf("")
    var userAge by mutableIntStateOf(0)

    fun addUser(){
        users.add(User(userName, userAge))
    }

    fun deleteUser(user : User){
        users.remove(user)
    }

    fun changeName(value : String){
        userName = value
    }

    fun changeAge(value : String){
        userAge = value.toIntOrNull() ?: userAge
    }
}