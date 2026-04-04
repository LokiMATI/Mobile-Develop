package com.example.labpplication.viewmodel

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import com.example.labpplication.classes.User

class UserViewModel(app : Application) : AndroidViewModel(app) {
    var userList = mutableStateListOf(
        User("Lucky","",""))
    var userLogin by mutableStateOf("")
    var userPassword by mutableStateOf("")
    var userEmail by mutableStateOf("")

    fun changeName(value: String){ userLogin = value }
    fun changeEmail(value: String){ userEmail = value }
    fun changePassword(value: String){ userPassword = value }

    fun addUser(){ userList.add(User(userLogin, userPassword, userEmail)) }

    fun getUserByLogin(login: String): User? { return userList.firstOrNull { u -> u.login == login} }

    fun updateUserByLogin(login: String, password: String, email: String) : Boolean {
        val user = getUserByLogin(login) ?: return false

        user.password = password
        user.email = email
        return true
    }

    fun deleteUserByLogin(login: String) : Boolean {
        val user = getUserByLogin(login) ?: return false
        return userList.remove(user)
    }
}
